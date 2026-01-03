package com.daonq1408.memberservice.mapper;

import com.daonq1408.memberservice.dto.request.RankRequest;
import com.daonq1408.memberservice.dto.response.RankResponse;
import com.daonq1408.memberservice.entity.Rank;
import com.daonq1408.memberservice.entity.Section;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface RankMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "section", source = "section")
    Rank toEntity(RankRequest rankRequest, Section section);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "section", source = "section")
    Rank updateRankFromRequest(RankRequest rankRequest, Section section, @MappingTarget Rank rank);


    RankResponse toResponse(Rank rank);
}
