package com.daonq1408.attendanceservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyAttendanceResponse {
    private long id;
    private long profileId;
    private int week;
    private int year;
    private boolean isPresent;
    private String status;
}
