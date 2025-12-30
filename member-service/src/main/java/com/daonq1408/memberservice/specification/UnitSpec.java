package com.daonq1408.memberservice.specification;

import com.daonq1408.memberservice.dto.request.filter.UnitRequestFilter;
import com.daonq1408.memberservice.entity.Section;
import com.daonq1408.memberservice.entity.Unit;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UnitSpec {

    public static Specification<Unit> filter(UnitRequestFilter filter) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            Join<Unit, Section> sectionJoin = root.join("section", JoinType.INNER);

            if (filter.getId() != null) {
                predicates.add(cb.equal(root.get("id"), filter.getId()));
            }
            if (filter.getName() != null) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
            }
            if (filter.getCode() != null) {
                predicates.add(cb.like(root.get("code").as(String.class), "%" + filter.getCode() + "%"));
            }
            if (filter.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), filter.getStatus()));
            }
            if (filter.getSectionId() != null) {
                predicates.add(cb.equal(sectionJoin.get("id"), filter.getSectionId()));
            }

            query.distinct(true);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
