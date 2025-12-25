package com.daonq1408.attendanceservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeeklyAttendanceResponse {
    long id;
    long profileId;
    int week;
    int year;
    boolean isPresent;
    String status;
}
