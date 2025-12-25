package com.daonq1408.attendanceservice.specification;

import com.daonq1408.attendanceservice.dto.filter.AttendanceFilterRequest;
import com.daonq1408.attendanceservice.entity.WeeklyAttendance;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class WeeklyAttendanceSpecification {
    public static Specification<WeeklyAttendance> filter(AttendanceFilterRequest request) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (request.getId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), request.getId()));
            }
            if (request.getProfileId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("profileId"), request.getProfileId()));
            }
            if (request.getWeek() != null) {
                predicates.add(criteriaBuilder.equal(root.get("week"), request.getWeek()));
            }
            if (request.getYear() != null) {
                predicates.add(criteriaBuilder.equal(root.get("year"), request.getYear()));
            }
            if (request.getIsPresent() != null) {
                predicates.add(criteriaBuilder.equal(root.get("isPresent"), request.getIsPresent()));
            }
            if (request.getStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), request.getStatus()));
            }
            if (request.getFromDate() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), request.getFromDate()));
            }
            if (request.getToDate() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), request.getToDate()));
            }

            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
