package com.daonq1408.memberservice.controller;

import com.daonq1408.memberservice.dto.api.ApiResponse;
import com.daonq1408.memberservice.dto.api.PageMeta;
import com.daonq1408.memberservice.dto.request.RoleRequest;
import com.daonq1408.memberservice.dto.request.filter.RoleRequestFilter;
import com.daonq1408.memberservice.dto.response.RoleResponse;
import com.daonq1408.memberservice.service.inter.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @PostMapping()
    public ApiResponse<RoleResponse> create(
            @RequestBody RoleRequest request
    ) {
        RoleResponse roleResponse = roleService.createRole(request);

        return ApiResponse.success(
                HttpStatus.CREATED,
                "Create role successfully",
                roleResponse,
                null
        );
    }


    @GetMapping()
    public ApiResponse<List<RoleResponse>> getByFilter(
            @ModelAttribute RoleRequestFilter filter,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<RoleResponse> responses = roleService.getByFilter(filter, pageable);

        PageMeta meta = PageMeta.builder()
                .currentPage(responses.getNumber() + 1)
                .size(responses.getSize())
                .lastPage(responses.getTotalPages())
                .totalElements(responses.getTotalElements())
                .build();

        return ApiResponse.success(
                HttpStatus.OK,
                "Get roles by filter successfully: " + responses.getTotalElements() + " records.",
                responses.getContent(),
                meta
        );
    }


    @PutMapping("{id}")
    public ApiResponse<RoleResponse> update(
            @PathVariable Long id,
            @RequestBody RoleRequest request
    ) {
        RoleResponse roleResponse = roleService.updateRole(id, request);

        return ApiResponse.success(
                HttpStatus.OK,
                "Update role successfully",
                roleResponse,
                null
        );
    }


    @DeleteMapping("{id}")
    public ApiResponse<RoleResponse> delete(
            @PathVariable Long id
    ) {
        RoleResponse roleResponse = roleService.deleteRole(id);
        return ApiResponse.success(
                HttpStatus.OK,
                "Delete role successfully",
                roleResponse,
                null
        );
    }
}