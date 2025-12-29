package com.daonq1408.memberservice.controller;

import com.daonq1408.memberservice.dto.api.ApiResponse;
import com.daonq1408.memberservice.dto.api.PageMeta;
import com.daonq1408.memberservice.dto.request.RankRequest;
import com.daonq1408.memberservice.dto.request.filter.RankRequestFilter;
import com.daonq1408.memberservice.dto.response.RankResponse;
import com.daonq1408.memberservice.service.inter.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ranks")
@RequiredArgsConstructor
public class RankController {

    private final RankService rankService;


    @PostMapping()
    public ApiResponse<RankResponse> create(
            @RequestBody RankRequest rankRequest
    ) {
        RankResponse rankResponse = rankService.createRank(rankRequest);

        return ApiResponse.success(
                HttpStatus.CREATED,
                "Create rank successfully",
                rankResponse,
                null
        );
    }


    @GetMapping()
    public ApiResponse<List<RankResponse>> getByFilter(
            @ModelAttribute RankRequestFilter filter,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<RankResponse> responses = rankService.getByFilter(filter, pageable);

        PageMeta meta = PageMeta.builder()
                .currentPage(responses.getNumber() + 1)
                .size(responses.getSize())
                .lastPage(responses.getTotalPages())
                .totalElements(responses.getTotalElements())
                .build();

        return ApiResponse.success(
                HttpStatus.OK,
                "Get ranks by filter successfully: " + responses.getTotalElements() + " records.",
                responses.getContent(),
                meta
        );
    }


    @PutMapping("{id}")
    public ApiResponse<RankResponse> update(
            @PathVariable long id,
            @RequestBody RankRequest rankRequest
    ) {
        RankResponse rankResponse = rankService.updateRank(id, rankRequest);

        return ApiResponse.success(
                HttpStatus.OK,
                "Update rank successfully",
                rankResponse,
                null
        );
    }


    @DeleteMapping("{id}")
    public ApiResponse<RankResponse> delete(
            @PathVariable long id
    ) {
        RankResponse rankResponse = rankService.deleteRank(id);
        return ApiResponse.success(
                HttpStatus.OK,
                "Delete rank successfully",
                rankResponse,
                null
        );
    }
}
