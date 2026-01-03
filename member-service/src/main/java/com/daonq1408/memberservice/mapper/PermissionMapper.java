package com.daonq1408.memberservice.mapper;

import com.daonq1408.memberservice.dto.response.PermissionResponse;
import com.daonq1408.memberservice.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = org.mapstruct.ReportingPolicy.IGNORE
)
public interface PermissionMapper {
    PermissionResponse toResponse(Permission permission);
}
