package com.daonq1408.attendanceservice.specification;

import com.daonq1408.attendanceservice.dto.filter.AttendanceFilterRequest;
import com.daonq1408.attendanceservice.entity.WeeklyAttendance;
import com.daonq1408.attendanceservice.enums.AttendanceStatus;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeeklyAttendanceSpecification {
    public static Specification<WeeklyAttendance> filter(AttendanceFilterRequest filterRequest) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (filterRequest.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), filterRequest.getId()));
            }
            if (filterRequest.getProfileId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("profileId"), filterRequest.getProfileId()));
            }
            if (filterRequest.getWeek() != null) {
                predicates.add(criteriaBuilder.equal(root.get("week"), filterRequest.getWeek()));
            }
            if (filterRequest.getYear() != null) {
                predicates.add(criteriaBuilder.equal(root.get("year"), filterRequest.getYear()));
            }
            if (filterRequest.getIsPresent() != null) {
                predicates.add(criteriaBuilder.equal(root.get("isPresent"), filterRequest.getIsPresent()));
            }
            if (filterRequest.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), filterRequest.getStatus()));
            }
            if (filterRequest.getFromDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), filterRequest.getFromDate()));
            }
            if (filterRequest.getToDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), filterRequest.getToDate()));
            }

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
