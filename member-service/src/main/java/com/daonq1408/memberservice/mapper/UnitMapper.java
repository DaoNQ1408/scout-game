package com.daonq1408.memberservice.mapper;

import com.daonq1408.memberservice.dto.request.UnitRequest;
import com.daonq1408.memberservice.dto.response.UnitResponse;
import com.daonq1408.memberservice.entity.Section;
import com.daonq1408.memberservice.entity.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface UnitMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "section", source = "section")
    Unit toEntity(UnitRequest request, Section section);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "section", source = "section")
    Unit updateFromRequest(UnitRequest request, Section section, @MappingTarget Unit unit);

    UnitResponse toResponse(Unit unit);
}
