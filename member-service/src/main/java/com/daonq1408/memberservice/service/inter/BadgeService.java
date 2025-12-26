package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.BadgeRequest;
import com.daonq1408.memberservice.dto.request.filter.BadgeRequestFilter;
import com.daonq1408.memberservice.entity.Badge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BadgeService {

    Badge createBadge(BadgeRequest request);

    Page<Badge> getByFilter(BadgeRequestFilter filter, Pageable pageable);

    Badge updateBadge(Long id, BadgeRequest request);

    Badge deleteBadge(Long id);
}
