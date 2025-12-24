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
    @Mapping(target = "status", source = "status")
    WeeklyAttendanceResponse toResponse(WeeklyAttendance weeklyAttendance);

    @Mapping(target = "isPresent", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    WeeklyAttendance toEntity(Long profileId, int week, int year);
}
