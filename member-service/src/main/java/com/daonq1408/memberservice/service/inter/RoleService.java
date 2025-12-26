package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.RoleRequest;
import com.daonq1408.memberservice.dto.request.filter.RoleRequestFilter;

import com.daonq1408.memberservice.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {

    Role createRole(RoleRequest request);

    Page<Role> getByFilter(RoleRequestFilter filter, Pageable pageable);

    Role updateRole(Long id, RoleRequest request);

    Role deleteRole(Long id);
}
