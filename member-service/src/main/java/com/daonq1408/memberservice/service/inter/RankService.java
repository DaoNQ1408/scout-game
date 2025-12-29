package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.RankRequest;
import com.daonq1408.memberservice.dto.request.filter.RankRequestFilter;
import com.daonq1408.memberservice.dto.response.RankResponse;
import com.daonq1408.memberservice.entity.Rank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RankService {

    RankResponse createRank(RankRequest request);

    Page<RankResponse> getByFilter(RankRequestFilter filter, Pageable pageable);

    Rank findById(Long id);

    RankResponse updateRank(Long id, RankRequest request);

    RankResponse deleteRank(Long id);
}