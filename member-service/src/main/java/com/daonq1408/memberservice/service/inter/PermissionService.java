package com.daonq1408.memberservice.service.inter;

import com.daonq1408.memberservice.dto.request.filter.PermissionRequestFilter;
import com.daonq1408.memberservice.dto.response.PermissionResponse;
import com.daonq1408.memberservice.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PermissionService {
    Page<PermissionResponse> getByFilter(PermissionRequestFilter filter, Pageable pageable);

    Permission getById(Long id);

    List<Permission> findAllByIds(List<Long> ids);
}
