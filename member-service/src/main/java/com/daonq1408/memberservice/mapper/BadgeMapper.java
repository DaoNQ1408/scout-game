package com.daonq1408.memberservice.mapper;

import com.daonq1408.memberservice.dto.request.BadgeRequest;
import com.daonq1408.memberservice.dto.response.BadgeResponse;
import com.daonq1408.memberservice.entity.Badge;
import com.daonq1408.memberservice.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface BadgeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "section", source = "section")
    Badge toEntity(BadgeRequest request, Section section);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "section", source = "section")
    Badge updateBadgeFromRequest(BadgeRequest request, Section section, @MappingTarget Badge badge);


    BadgeResponse toBadgeResponse(Badge badge);
}
