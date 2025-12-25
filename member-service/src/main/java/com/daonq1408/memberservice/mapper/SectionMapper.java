package com.daonq1408.memberservice.mapper;

import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.entity.Section;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    Section toEntity(SectionRequest sectionRequest);
}
