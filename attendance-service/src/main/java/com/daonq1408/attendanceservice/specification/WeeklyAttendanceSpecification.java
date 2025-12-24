package com.daonq1408.attendanceservice.specification;

import com.daonq1408.attendanceservice.entity.WeeklyAttendance;
import com.daonq1408.attendanceservice.enums.AttendanceStatus;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeeklyAttendanceSpecification {
    public static Specification<WeeklyAttendance> filter(
            Long id,
            Long profileId,
            Integer week,
            Integer year,
            Boolean isPresent,
            AttendanceStatus status,
            LocalDateTime fromDate,
            LocalDateTime toDate
    ) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(id != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), id));
            }
            if(profileId != null) {
                predicates.add(criteriaBuilder.equal(root.get("profileId"), profileId));
            }
            if(week != null) {
                predicates.add(criteriaBuilder.equal(root.get("week"), week));
            }
            if(year != null) {
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
            }
            if(isPresent != null) {
                predicates.add(criteriaBuilder.equal(root.get("isPresent"), isPresent));
            }
            if(status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }
            if(fromDate != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), fromDate));
            }
            if(toDate != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("updatedAt"), toDate));
            }

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
