package com.daonq1408.memberservice.controller;

import com.daonq1408.memberservice.dto.api.ApiResponse;
import com.daonq1408.memberservice.dto.api.PageMeta;
import com.daonq1408.memberservice.dto.request.filter.PermissionRequestFilter;
import com.daonq1408.memberservice.dto.response.PermissionResponse;
import com.daonq1408.memberservice.service.inter.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;


    @GetMapping()
    public ApiResponse<List<PermissionResponse>> getByFilter(
            @ModelAttribute PermissionRequestFilter filter,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<PermissionResponse> responses = permissionService.getByFilter(filter, pageable);

        PageMeta meta = PageMeta.builder()
                .currentPage(responses.getNumber() + 1)
                .size(responses.getSize())
                .lastPage(responses.getTotalPages())
                .totalElements(responses.getTotalElements())
                .build();

        return ApiResponse.success(
                HttpStatus.OK,
                "Get permissions by filter successfully: " + responses.getTotalElements() + " records.",
                responses.getContent(),
                meta
        );
    }
}
