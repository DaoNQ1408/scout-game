package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.dto.request.filter.PermissionRequestFilter;
import com.daonq1408.memberservice.dto.response.PermissionResponse;
import com.daonq1408.memberservice.entity.Permission;
import com.daonq1408.memberservice.mapper.PermissionMapper;
import com.daonq1408.memberservice.repository.PermissionRepository;
import com.daonq1408.memberservice.service.inter.PermissionService;
import com.daonq1408.memberservice.specification.PermissionSpec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;


    @Override
    public Page<PermissionResponse> getByFilter(PermissionRequestFilter filter, Pageable pageable) {
        return permissionRepository.findAll(
                PermissionSpec.filter(filter),
                pageable
        ).map(permissionMapper::toResponse);
    }

    @Override
    public Permission getById(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Permission not found with id: " + id)
                );
    }

    @Override
    public List<Permission> findAllByIds(List<Long> ids) {
        return permissionRepository.findAllById(ids);
    }
}
