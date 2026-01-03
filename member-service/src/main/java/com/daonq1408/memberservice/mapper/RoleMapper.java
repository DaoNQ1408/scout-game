package com.daonq1408.memberservice.mapper;

import com.daonq1408.memberservice.dto.request.RoleRequest;
import com.daonq1408.memberservice.dto.response.RoleResponse;
import com.daonq1408.memberservice.entity.Permission;
import com.daonq1408.memberservice.entity.Role;
import com.daonq1408.memberservice.service.inter.PermissionService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public abstract class RoleMapper {

    @Autowired
    protected PermissionService permissionService;


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    public abstract Role toEntity(RoleRequest roleRequest);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateFromRequest(RoleRequest request, @MappingTarget Role role);


    @AfterMapping
    protected void mapPermissions(RoleRequest request, @MappingTarget Role role) {
        if (request.getPermissionIds() != null) {
            if (request.getPermissionIds().isEmpty()) {
                role.setPermissions(new HashSet<>());
            } else {
                List<Permission> perms = permissionService.findAllByIds(request.getPermissionIds());
                role.setPermissions(new HashSet<>(perms));
            }
        }
    }


    public abstract RoleResponse toResponse(Role role);
}