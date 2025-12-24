package com.daonq1408.attendanceservice.repository;

import com.daonq1408.attendanceservice.entity.WeeklyAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WeeklyAttendanceRepository extends JpaRepository<WeeklyAttendance, Long>,
        JpaSpecificationExecutor<WeeklyAttendance> {
    boolean existsByProfileIdAndWeekAndYear(Long id, int week, int year);
}
