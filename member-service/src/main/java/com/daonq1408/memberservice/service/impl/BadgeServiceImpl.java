package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.dto.request.BadgeRequest;
import com.daonq1408.memberservice.dto.request.filter.BadgeRequestFilter;
import com.daonq1408.memberservice.dto.response.BadgeResponse;
import com.daonq1408.memberservice.entity.Badge;
import com.daonq1408.memberservice.entity.Rank;
import com.daonq1408.memberservice.entity.Section;
import com.daonq1408.memberservice.enums.ScoutElementStatus;
import com.daonq1408.memberservice.mapper.BadgeMapper;
import com.daonq1408.memberservice.repository.BadgeRepository;
import com.daonq1408.memberservice.repository.SectionRepository;
import com.daonq1408.memberservice.service.inter.BadgeService;
import com.daonq1408.memberservice.service.inter.SectionService;
import com.daonq1408.memberservice.specification.BadgeSpec;
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
public class BadgeServiceImpl implements BadgeService {

    private final BadgeMapper badgeMapper;
    private final BadgeRepository badgeRepository;
    private final SectionService sectionService;


    @Override
    public BadgeResponse createBadge(BadgeRequest request) {

        Section section = sectionService.getById(request.getSectionId());

        Badge badge = badgeMapper.toEntity(request, section);

        Badge savedBadge = badgeRepository.save(badge);

        return badgeMapper.toBadgeResponse(savedBadge);
    }


    @Override
    public Page<BadgeResponse> getByFilter(BadgeRequestFilter filter, Pageable pageable) {
        return badgeRepository.findAll(
                BadgeSpec.filter(filter),
                pageable
        ).map(badgeMapper::toBadgeResponse);
    }


    @Override
    public Badge getById(Long id) {
        return badgeRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Badge not found with id: " + id)
                );
    }


    @Override
    public BadgeResponse updateBadge(Long id, BadgeRequest request) {

        Section section = sectionService.getById(request.getSectionId());

        Badge badge = getById(id);

        badgeMapper.updateBadgeFromRequest(request, section, badge);

        Badge updatedBadge = badgeRepository.save(badge);

        return badgeMapper.toBadgeResponse(updatedBadge);
    }


    @Override
    public BadgeResponse deleteBadge(Long id) {

        Badge badge = getById(id);

        badge.setStatus(ScoutElementStatus.DELETED);

        Badge deletedBadge = badgeRepository.save(badge);

        return badgeMapper.toBadgeResponse(deletedBadge);
    }
}
