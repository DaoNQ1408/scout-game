package com.daonq1408.memberservice.mapper;

import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.dto.response.SectionResponse;
import com.daonq1408.memberservice.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface SectionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Section toEntity(SectionRequest sectionRequest);

    SectionResponse toResponse(Section section);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Section updatedFromRequest(@MappingTarget Section section, SectionRequest sectionRequest);
}
