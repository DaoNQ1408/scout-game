package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.entity.Section;
import com.daonq1408.memberservice.mapper.SectionMapper;
import com.daonq1408.memberservice.repository.SectionRepository;
import com.daonq1408.memberservice.service.inter.SectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;

    @Override
    @Transactional
    public Section createSection(SectionRequest sectionRequest) {
        Section createdSection = sectionMapper.toEntity(sectionRequest);

        return null;
    }

    @Override
    public List<Section> getByFilter(Long id, String name, String code) {
        return List.of();
    }

    @Override
    @Transactional
    public Section updateSection(Long id, SectionRequest sectionRequest) {
        return null;
    }

    @Override
    @Transactional
    public Section deleteSection(Long id) {
        return null;
    }
}
