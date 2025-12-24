package com.daonq1408.attendanceservice.controller;

import com.daonq1408.attendanceservice.dto.request.WeeklyAttendanceRequest;
import com.daonq1408.attendanceservice.dto.response.WeeklyAttendanceResponse;
import com.daonq1408.attendanceservice.enums.AttendanceStatus;
import com.daonq1408.attendanceservice.service.inter.WeeklyAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/weekly-attendances")
@RequiredArgsConstructor
public class WeeklyAttendanceController {

    private final WeeklyAttendanceService weeklyAttendanceService;


    @PostMapping("/take-attendance")
    public List<WeeklyAttendanceResponse> takeAttendance(
            @RequestBody List<WeeklyAttendanceRequest> requests
    ) {
        return weeklyAttendanceService.takeAttendance(requests);
    }


    @GetMapping
    public List<WeeklyAttendanceResponse> getByFilter(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Long profileId,
            @RequestParam(required = false) Integer week,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Boolean isPresent,
            @RequestParam(required = false) AttendanceStatus status,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime fromDate,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime toDate
    ) {
        return weeklyAttendanceService.getByFilter(
                id,
                profileId,
                week,
                year,
                isPresent,
                status,
                fromDate,
                toDate
        );
    }
}
