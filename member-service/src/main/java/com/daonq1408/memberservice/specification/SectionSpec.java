package com.daonq1408.memberservice.specification;

import com.daonq1408.memberservice.dto.request.filter.SectionRequestFilter;
import com.daonq1408.memberservice.entity.Section;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SectionSpec {

    public static Specification<Section> filter(SectionRequestFilter filter) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (filter.getId() != null) {
                predicates.add(cb.equal(root.get("id"), filter.getId()));
            }
            if (filter.getName() != null) {
                predicates.add(cb.like(root.get("name").as(String.class), "%" + filter.getName() + "%"));
            }
            if (filter.getCode() != null) {
                predicates.add(cb.like(root.get("code").as(String.class), "%" + filter.getCode() + "%"));
            }

            query.distinct(true);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
