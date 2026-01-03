package com.daonq1408.memberservice.controller;

import com.daonq1408.memberservice.dto.api.ApiResponse;
import com.daonq1408.memberservice.dto.api.PageMeta;
import com.daonq1408.memberservice.dto.request.UnitRequest;
import com.daonq1408.memberservice.dto.request.filter.UnitRequestFilter;
import com.daonq1408.memberservice.dto.response.UnitResponse;
import com.daonq1408.memberservice.service.inter.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/units")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;


    @PostMapping()
    public ApiResponse<UnitResponse> create(
            @RequestBody UnitRequest unitRequest
    ) {
        UnitResponse unitResponse = unitService.createUnit(unitRequest);

        return ApiResponse.success(
                HttpStatus.CREATED,
                "Create unit successfully",
                unitResponse,
                null
        );
    }


    @GetMapping()
    public ApiResponse<List<UnitResponse>> getByFilter(
            @ModelAttribute UnitRequestFilter filter,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<UnitResponse> responses = unitService.getByFilter(filter, pageable);

        PageMeta meta = PageMeta.builder()
                .currentPage(responses.getNumber() + 1)
                .size(responses.getSize())
                .lastPage(responses.getTotalPages())
                .totalElements(responses.getTotalElements())
                .build();

        return ApiResponse.success(
                HttpStatus.OK,
                "Get units by filter successfully: " + responses.getTotalElements() + " records.",
                responses.getContent(),
                meta
        );
    }


    @PutMapping("{id}")
    public ApiResponse<UnitResponse> update(
            @PathVariable long id,
            @RequestBody UnitRequest unitRequest
    ) {
        UnitResponse unitResponse = unitService.updateUnit(id, unitRequest);

        return ApiResponse.success(
                HttpStatus.OK,
                "Update section successfully",
                unitResponse,
                null
        );
    }


    @DeleteMapping("{id}")
    public ApiResponse<UnitResponse> delete(
            @PathVariable long id
    ) {
        UnitResponse unitResponse = unitService.deleteUnit(id);
        return ApiResponse.success(
                HttpStatus.OK,
                "Delete section successfully",
                unitResponse,
                null
        );
    }
}
