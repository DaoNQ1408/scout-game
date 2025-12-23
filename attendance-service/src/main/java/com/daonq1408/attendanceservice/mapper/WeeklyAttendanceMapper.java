package com.daonq1408.attendanceservice.mapper;

import com.daonq1408.attendanceservice.dto.response.WeeklyAttendanceResponse;
import com.daonq1408.attendanceservice.entity.WeeklyAttendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface WeeklyAttendanceMapper {
    @Mapping(target = "status", source = "weeklyAttendance.status.toString")
    WeeklyAttendanceResponse toResponse(WeeklyAttendance weeklyAttendance);
}
