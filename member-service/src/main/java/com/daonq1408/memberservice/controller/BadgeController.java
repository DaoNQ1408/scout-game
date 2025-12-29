package com.daonq1408.memberservice.controller;

import com.daonq1408.memberservice.dto.api.ApiResponse;
import com.daonq1408.memberservice.dto.api.PageMeta;
import com.daonq1408.memberservice.dto.request.BadgeRequest;
import com.daonq1408.memberservice.dto.request.RankRequest;
import com.daonq1408.memberservice.dto.request.filter.BadgeRequestFilter;
import com.daonq1408.memberservice.dto.request.filter.RankRequestFilter;
import com.daonq1408.memberservice.dto.response.BadgeResponse;
import com.daonq1408.memberservice.dto.response.RankResponse;
import com.daonq1408.memberservice.service.inter.BadgeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/badges")
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;


    @PostMapping()
    public ApiResponse<BadgeResponse> create(
            @RequestBody BadgeRequest badgeRequest
    ) {
        BadgeResponse response = badgeService.createBadge(badgeRequest);

        return ApiResponse.success(
                HttpStatus.CREATED,
                "Create badge successfully",
                response,
                null
        );
    }


    @GetMapping()
    public ApiResponse<List<BadgeResponse>> getByFilter(
            @ModelAttribute BadgeRequestFilter filter,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<BadgeResponse> responses = badgeService.getByFilter(filter, pageable);

        PageMeta meta = PageMeta.builder()
                .currentPage(responses.getNumber() + 1)
                .size(responses.getSize())
                .lastPage(responses.getTotalPages())
                .totalElements(responses.getTotalElements())
                .build();

        return ApiResponse.success(
                HttpStatus.OK,
                "Get badges by filter successfully: " + responses.getTotalElements() + " records.",
                responses.getContent(),
                meta
        );
    }


    @PutMapping("{id}")
    public ApiResponse<BadgeResponse> update(
            @PathVariable long id,
            @RequestBody BadgeRequest badgeRequest
    ) {
        BadgeResponse response = badgeService.updateBadge(id, badgeRequest);

        return ApiResponse.success(
                HttpStatus.OK,
                "Update badge successfully",
                response,
                null
        );
    }


    @DeleteMapping("{id}")
    public ApiResponse<BadgeResponse> delete(
            @PathVariable long id
    ) {
        BadgeResponse rankResponse = badgeService.deleteBadge(id);
        return ApiResponse.success(
                HttpStatus.OK,
                "Delete badge successfully",
                rankResponse,
                null
        );
    }
}
