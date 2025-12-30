package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.dto.request.UnitRequest;
import com.daonq1408.memberservice.dto.request.filter.UnitRequestFilter;
import com.daonq1408.memberservice.dto.response.UnitResponse;
import com.daonq1408.memberservice.entity.Section;
import com.daonq1408.memberservice.entity.Unit;
import com.daonq1408.memberservice.enums.ScoutElementStatus;
import com.daonq1408.memberservice.mapper.UnitMapper;
import com.daonq1408.memberservice.repository.UnitRepository;
import com.daonq1408.memberservice.service.inter.SectionService;
import com.daonq1408.memberservice.service.inter.UnitService;
import com.daonq1408.memberservice.specification.UnitSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;
    private final SectionService sectionService;


    @Override
    @Transactional
    public UnitResponse createUnit(UnitRequest request) {

        Unit parentUnit = (request.getParentUnitId() != null) ?
                getById(request.getParentUnitId()) : null;
        Section section = sectionService.getById(request.getSectionId());

        Unit unit = unitMapper.toEntity(request, section);
        unit.setParent(parentUnit);

        Unit savedUnit = unitRepository.save(unit);

        return unitMapper.toResponse(savedUnit);
    }


    @Override
    public Page<UnitResponse> getByFilter(UnitRequestFilter filter, Pageable pageable) {
        return unitRepository.findAll(
                UnitSpec.filter(filter),
                pageable
        ).map(unitMapper::toResponse);
    }


    @Override
    public Unit getById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Unit not found with id: " + id)
                );
    }


    @Override
    @Transactional
    public UnitResponse updateUnit(Long id, UnitRequest request) {

        if (request.getParentUnitId() != null && request.getParentUnitId().equals(id)) {
            throw new IllegalArgumentException("A unit cannot be its own parent");
        }

        Unit parentUnit = (request.getParentUnitId() != null) ?
                getById(request.getParentUnitId()) : null;
        Section section = sectionService.getById(request.getSectionId());
        Unit unit = getById(id);

        Unit updatedUnit = unitMapper.updateFromRequest(request, section, unit);
        updatedUnit.setParent(parentUnit);

        updatedUnit = unitRepository.save(updatedUnit);

        return unitMapper.toResponse(updatedUnit);
    }


    @Override
    @Transactional
    public UnitResponse deleteUnit(Long id) {

        Unit unit = getById(id);

        unit.setStatus(ScoutElementStatus.DELETED);

        updateChildUnitAfterDelete(unit);

        return unitMapper.toResponse(unit);
    }


    private void updateChildUnitAfterDelete(Unit parentUnit) {
        List<Unit> childUnits = unitRepository.findByParent(parentUnit);

        if (childUnits.isEmpty()) return;

        for (Unit childUnit : childUnits) {
            childUnit.setParent(null);
        }

        unitRepository.saveAll(childUnits);
    }
}
