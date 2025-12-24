package com.daonq1408.attendanceservice.service.inter;

import com.daonq1408.attendanceservice.dto.request.WeeklyAttendanceRequest;
import com.daonq1408.attendanceservice.dto.response.WeeklyAttendanceResponse;
import com.daonq1408.attendanceservice.enums.AttendanceStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface WeeklyAttendanceService {

    List<WeeklyAttendanceResponse> takeAttendance(List<WeeklyAttendanceRequest> requests);

    List<WeeklyAttendanceResponse> getByFilter(Long id,
                                               Long profileId,
                                               Integer week,
                                               Integer year,
                                               Boolean isPresent,
                                               AttendanceStatus status,
                                               LocalDateTime fromDate,
                                               LocalDateTime toDate);

    void runWeeklyAttendanceJob();

    void finalizePreviousWeekAttendance();
}
