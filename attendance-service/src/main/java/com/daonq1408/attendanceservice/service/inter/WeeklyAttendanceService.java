package com.daonq1408.attendanceservice.service.inter;

import com.daonq1408.attendanceservice.dto.filter.AttendanceFilterRequest;
import com.daonq1408.attendanceservice.dto.request.WeeklyAttendanceRequest;
import com.daonq1408.attendanceservice.dto.response.WeeklyAttendanceResponse;
import com.daonq1408.attendanceservice.enums.AttendanceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface WeeklyAttendanceService {

    List<WeeklyAttendanceResponse> takeAttendance(List<WeeklyAttendanceRequest> requests);

    Page<WeeklyAttendanceResponse> getByFilter(AttendanceFilterRequest filterRequest, Pageable pageable);

    void runWeeklyAttendanceJob();

    void finalizePreviousWeekAttendance();
}
