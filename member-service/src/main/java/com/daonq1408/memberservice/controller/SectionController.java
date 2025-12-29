package com.daonq1408.memberservice.controller;

import com.daonq1408.memberservice.dto.api.ApiResponse;
import com.daonq1408.memberservice.dto.api.PageMeta;
import com.daonq1408.memberservice.dto.request.SectionRequest;
import com.daonq1408.memberservice.dto.request.filter.SectionRequestFilter;
import com.daonq1408.memberservice.dto.response.SectionResponse;
import com.daonq1408.memberservice.service.inter.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;


    @PostMapping()
    public ApiResponse<SectionResponse> create(
            @RequestBody SectionRequest sectionRequest
    ) {
        SectionResponse sectionResponse = sectionService.createSection(sectionRequest);

        return ApiResponse.success(
                HttpStatus.CREATED,
                "Create section successfully",
                sectionResponse,
                null
        );
    }


    @GetMapping()
    public ApiResponse<List<SectionResponse>> getByFilter(
            @ModelAttribute SectionRequestFilter filter,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<SectionResponse> responses = sectionService.getByFilter(filter, pageable);

        PageMeta meta = PageMeta.builder()
                .currentPage(responses.getNumber() + 1)
                .size(responses.getSize())
                .lastPage(responses.getTotalPages())
                .totalElements(responses.getTotalElements())
                .build();

        return ApiResponse.success(
                HttpStatus.OK,
                "Get sections by filter successfully: " + responses.getTotalElements() + " records.",
                responses.getContent(),
                meta
        );
    }


    @PutMapping("{id}")
    public ApiResponse<SectionResponse> update(
            @PathVariable long id,
            @RequestBody SectionRequest sectionRequest
    ) {
        SectionResponse sectionResponse = sectionService.updateSection(id, sectionRequest);

        return ApiResponse.success(
                HttpStatus.OK,
                "Update section successfully",
                sectionResponse,
                null
        );
    }


    @DeleteMapping("{id}")
    public ApiResponse<SectionResponse> delete(
            @PathVariable long id
    ) {
        SectionResponse sectionResponse = sectionService.deleteSection(id);
        return ApiResponse.success(
                HttpStatus.OK,
                "Delete section successfully",
                sectionResponse,
                null
        );
    }
}
