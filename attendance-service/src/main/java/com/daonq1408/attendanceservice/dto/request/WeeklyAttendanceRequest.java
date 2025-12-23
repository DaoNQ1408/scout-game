package com.daonq1408.attendanceservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyAttendanceRequest {
    private long id;
    private boolean isPresent;
}
