package com.daonq1408.memberservice.service.impl;

import com.daonq1408.memberservice.dto.request.RoleRequest;
import com.daonq1408.memberservice.dto.request.filter.RoleRequestFilter;
import com.daonq1408.memberservice.dto.response.RoleResponse;
import com.daonq1408.memberservice.entity.Role;
import com.daonq1408.memberservice.enums.ScoutElementStatus;
import com.daonq1408.memberservice.mapper.RoleMapper;
import com.daonq1408.memberservice.repository.RoleRepository;
import com.daonq1408.memberservice.service.inter.RoleService;
import com.daonq1408.memberservice.specification.RoleSpec;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;


    @Override
    @Transactional
    public RoleResponse createRole(RoleRequest request) {

        var role = roleMapper.toEntity(request);

        var savedRole = roleRepository.save(role);

        return roleMapper.toResponse(savedRole);
    }


    @Override
    public Page<RoleResponse> getByFilter(RoleRequestFilter filter, Pageable pageable) {
        return roleRepository.findAll(
                RoleSpec.filter(filter),
                pageable
        ).map(roleMapper::toResponse);
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Role not found")
                );
    }


    @Override
    @Transactional
    public RoleResponse updateRole(Long id, RoleRequest request) {
        var role = getById(id);

        roleMapper.updateFromRequest(request, role);

        var savedRole = roleRepository.save(role);

        return roleMapper.toResponse(savedRole);
    }


    @Override
    @Transactional
    public RoleResponse deleteRole(Long id) {
        var role = getById(id);

        role.setStatus(ScoutElementStatus.DELETED);

        var savedRole = roleRepository.save(role);

        return roleMapper.toResponse(savedRole);
    }
}