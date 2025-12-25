package com.daonq1408.attendanceservice.service.impl;

import com.daonq1408.attendanceservice.client.ScoutProfileClient;
import com.daonq1408.attendanceservice.dto.filter.AttendanceFilterRequest;
import com.daonq1408.attendanceservice.dto.request.WeeklyAttendanceRequest;
import com.daonq1408.attendanceservice.dto.response.WeeklyAttendanceResponse;
import com.daonq1408.attendanceservice.entity.WeeklyAttendance;
import com.daonq1408.attendanceservice.enums.AttendanceStatus;
import com.daonq1408.attendanceservice.mapper.WeeklyAttendanceMapper;
import com.daonq1408.attendanceservice.repository.WeeklyAttendanceRepository;
import com.daonq1408.attendanceservice.service.inter.WeeklyAttendanceService;
import com.daonq1408.attendanceservice.specification.WeeklyAttendanceSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class WeeklyAttendanceServiceImpl implements WeeklyAttendanceService {

    private final WeeklyAttendanceRepository weekAttendanceRepository;
    private final WeeklyAttendanceMapper weekAttendanceMapper;
    private final ScoutProfileClient scoutProfileClient;


    @Override
    @Transactional
    public List<WeeklyAttendanceResponse> takeAttendance(List<WeeklyAttendanceRequest> requests) {

        Map<Long, Boolean> requestMap = requests.stream().collect(Collectors.toMap(WeeklyAttendanceRequest::getId, WeeklyAttendanceRequest::isPresent));

        List<WeeklyAttendance> weeklyAttendances = weekAttendanceRepository.findAllById(requests.stream().map(WeeklyAttendanceRequest::getId).toList());

        weeklyAttendances.stream().forEach(weeklyAttendance -> {
            if (weeklyAttendance.getStatus() == AttendanceStatus.FINALIZED) {
                throw new RuntimeException("Attendance has been finalized and cannot be changed.");
            } else {
                weeklyAttendance.setIsPresent(requestMap.get(weeklyAttendance.getId()));
            }
        });

        List<WeeklyAttendance> savedAttendances = weekAttendanceRepository.saveAll(weeklyAttendances);

        return savedAttendances.stream().map(weekAttendanceMapper::toResponse).toList();
    }


    @Override
    public Page<WeeklyAttendanceResponse> getByFilter(AttendanceFilterRequest attendanceFilterRequest, Pageable pageable) {
        return weekAttendanceRepository.findAll(
                WeeklyAttendanceSpecification.filter(attendanceFilterRequest),
                pageable
        ).map(weekAttendanceMapper::toResponse);
    }


    @Override
    @Scheduled(cron = "0 59 23 ? * SAT", zone = "Asia/Ho_Chi_Minh")
    public void runWeeklyAttendanceJob() {

        int createdCount = createWeeklyAttendance();

        log.info("Weekly attendance records created: {}", createdCount);
    }


    @Transactional
    public int createWeeklyAttendance() {

        List<Long> profileIds = scoutProfileClient.getActiveScoutProfileIds();
        int week = LocalDate.now().get(WeekFields.ISO.weekOfWeekBasedYear());
        int year = LocalDateTime.now().getYear();

        List<WeeklyAttendance> weeklyAttendances = profileIds.stream()
                .filter(
                        id -> !weekAttendanceRepository.existsByProfileIdAndWeekAndYear(id, week, year)
                )
                .map(
                        id -> weekAttendanceMapper.toEntity(id, week, year)
                )
                .toList();

        List<WeeklyAttendance> saved = weekAttendanceRepository.saveAll(weeklyAttendances);

        return saved.size();
    }


    @Override
    @Scheduled(cron = "0 59 23 ? * SUN", zone = "Asia/Ho_Chi_Minh")
    public void finalizePreviousWeekAttendance() {

        int finalizedAttendance = finalizeWeeklyAttendance();

        log.info("Weekly attendance records finalized: {}", finalizedAttendance);
    }


    @Transactional
    public int finalizeWeeklyAttendance() {

        LocalDate lastWeek = LocalDate.now().minusWeeks(1);
        int week = lastWeek.get(WeekFields.ISO.weekOfWeekBasedYear());
        int year = LocalDateTime.now().getYear();

        List<WeeklyAttendance> weeklyAttendances = weekAttendanceRepository.findAll().stream().filter(wa -> wa.getWeek() == week && wa.getYear() == year).toList();

        weeklyAttendances.forEach(wa -> wa.setStatus(AttendanceStatus.FINALIZED));

        List<WeeklyAttendance> saved = weekAttendanceRepository.saveAll(weeklyAttendances);

        return saved.size();
    }
}
