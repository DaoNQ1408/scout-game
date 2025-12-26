package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.PermissionRequest;
import com.daonq1408.memberservice.dto.request.filter.PermissionRequestFilter;
import com.daonq1408.memberservice.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermissionService {

    Permission createPermission(PermissionRequest request);

    Page<Permission> getByFilter(PermissionRequestFilter filter, Pageable pageable);

    Permission updatePermission(Long id, PermissionRequest request);

    Permission deletePermission(Long id);
}
