package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.RoleRequest;
import com.daonq1408.memberservice.dto.request.filter.RoleRequestFilter;
import com.daonq1408.memberservice.dto.response.RoleResponse;
import com.daonq1408.memberservice.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {

    RoleResponse createRole(RoleRequest request);

    Page<RoleResponse> getByFilter(RoleRequestFilter filter, Pageable pageable);

    Role getById(Long id);

    RoleResponse updateRole(Long id, RoleRequest request);

    RoleResponse deleteRole(Long id);
}
