package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.UnitRequest;
import com.daonq1408.memberservice.dto.request.filter.UnitRequestFilter;
import com.daonq1408.memberservice.dto.response.UnitResponse;
import com.daonq1408.memberservice.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService {

    UnitResponse createUnit(UnitRequest request);

    Page<UnitResponse> getByFilter(UnitRequestFilter filter, Pageable pageable);

    Unit getById(Long id);

    UnitResponse updateUnit(Long id, UnitRequest request);

    UnitResponse deleteUnit(Long id);
}
