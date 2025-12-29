package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.BadgeRequest;
import com.daonq1408.memberservice.dto.request.filter.BadgeRequestFilter;
import com.daonq1408.memberservice.dto.response.BadgeResponse;
import com.daonq1408.memberservice.entity.Badge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BadgeService {

    BadgeResponse createBadge(BadgeRequest request);

    Page<BadgeResponse> getByFilter(BadgeRequestFilter filter, Pageable pageable);

    Badge getById(Long id);

    BadgeResponse updateBadge(Long id, BadgeRequest request);

    BadgeResponse deleteBadge(Long id);
}
