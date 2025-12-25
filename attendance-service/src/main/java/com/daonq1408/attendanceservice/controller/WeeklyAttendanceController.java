package com.daonq1408.attendanceservice.controller;

import com.daonq1408.attendanceservice.dto.api.ApiResponse;
import com.daonq1408.attendanceservice.dto.api.PageMeta;
import com.daonq1408.attendanceservice.dto.filter.AttendanceFilterRequest;
import com.daonq1408.attendanceservice.dto.request.WeeklyAttendanceRequest;
import com.daonq1408.attendanceservice.dto.response.WeeklyAttendanceResponse;
import com.daonq1408.attendanceservice.service.inter.WeeklyAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weekly-attendances")
@RequiredArgsConstructor
public class WeeklyAttendanceController {

    private final WeeklyAttendanceService weeklyAttendanceService;


    @PostMapping("/take-attendance")
    public ApiResponse<List<WeeklyAttendanceResponse>> takeAttendance(
            @RequestBody List<WeeklyAttendanceRequest> requests
    ) {
        List<WeeklyAttendanceResponse> responses = weeklyAttendanceService.takeAttendance(requests);

        return ApiResponse.success(
                HttpStatus.OK,
                "Take attendance successfully: " + responses.size() + " records.",
                responses,
                null);
    }


    @GetMapping
    public ApiResponse<List<WeeklyAttendanceResponse>> getByFilter(
            @ModelAttribute AttendanceFilterRequest attendanceFilterRequest,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        Page<WeeklyAttendanceResponse> responses = weeklyAttendanceService.getByFilter(attendanceFilterRequest, pageable);

        PageMeta meta = PageMeta.builder()
                .currentPage(responses.getNumber() + 1)
                .size(responses.getSize())
                .lastPage(responses.getTotalPages())
                .totalElements(responses.getTotalElements())
                .build();

        return ApiResponse.success(
                HttpStatus.OK,
                "Get weekly attendance by filter successfully: " + responses.getTotalElements() + " records.",
                responses.getContent(),
                meta);
    }
}
