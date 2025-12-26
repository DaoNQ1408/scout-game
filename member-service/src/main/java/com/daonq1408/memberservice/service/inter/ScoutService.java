package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.ScoutRequest;
import com.daonq1408.memberservice.dto.request.filter.ScoutRequestFilter;
import com.daonq1408.memberservice.entity.Scout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScoutService {

    Scout createScout(ScoutRequest request);

    Page<Scout> getByFilter(ScoutRequestFilter filter, Pageable pageable);

    Scout updateScout(Long id, ScoutRequest request);

    Scout deleteScout(Long id);
}
