package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.UnitRequest;
import com.daonq1408.memberservice.dto.request.filter.UnitRequestFilter;
import com.daonq1408.memberservice.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService {

    Unit createUnit(UnitRequest request);

    Page<Unit> getByFilter(UnitRequestFilter filter, Pageable pageable);

    Unit updateUnit(Long id, UnitRequest request);

    Unit deleteUnit(Long id);
}
