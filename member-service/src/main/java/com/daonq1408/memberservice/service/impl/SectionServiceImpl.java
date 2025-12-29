package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.dto.request.filter.SectionRequestFilter;
import com.daonq1408.memberservice.dto.response.SectionResponse;
import com.daonq1408.memberservice.entity.Section;
import com.daonq1408.memberservice.enums.ScoutElementStatus;
import com.daonq1408.memberservice.mapper.SectionMapper;
import com.daonq1408.memberservice.repository.SectionRepository;
import com.daonq1408.memberservice.service.inter.SectionService;
import com.daonq1408.memberservice.specification.SectionSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;


    @Override
    @Transactional
    public SectionResponse createSection(SectionRequest sectionRequest) {

        Section section = sectionMapper.toEntity(sectionRequest);

        Section savedSection = sectionRepository.save(section);

        return sectionMapper.toResponse(savedSection);
    }


    @Override
    public Page<SectionResponse> getByFilter(SectionRequestFilter filter, Pageable pageable) {
        return sectionRepository.findAll(
                SectionSpec.filter(filter),
                pageable
        ).map(sectionMapper::toResponse);
    }


    @Override
    @Transactional
    public SectionResponse updateSection(Long id, SectionRequest sectionRequest) {

        Section section = sectionRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Section not found")
                );

        sectionMapper.updatedFromRequest(section, sectionRequest);

        Section updatedSection = sectionRepository.save(section);

        return sectionMapper.toResponse(updatedSection);
    }


    @Override
    @Transactional
    public SectionResponse deleteSection(Long id) {

        Section section = sectionRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Section not found")
                );

        section.setStatus(ScoutElementStatus.DELETED);

        Section deletedSection = sectionRepository.save(section);

        return sectionMapper.toResponse(deletedSection);
    }

}
