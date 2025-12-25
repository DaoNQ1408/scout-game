package com.daonq1408.attendanceservice.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeeklyAttendanceRequest {
    long id;
    boolean isPresent;
}
