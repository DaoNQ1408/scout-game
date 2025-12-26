package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.RankRequest;
import com.daonq1408.memberservice.dto.request.filter.RankRequestFilter;
import com.daonq1408.memberservice.entity.Rank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RankService {

    Rank createRank(RankRequest request);

    Page<Rank> getByFilter(RankRequestFilter filter, Pageable pageable);

    Rank updateRank(Long id, RankRequest request);

    Rank deleteRank(Long id);
}
