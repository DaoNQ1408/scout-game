package com.daonq1408.memberservice.specification;

import com.daonq1408.memberservice.dto.request.filter.PermissionRequestFilter;
import com.daonq1408.memberservice.entity.Permission;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PermissionSpec {

    public static Specification<Permission> filter(PermissionRequestFilter filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getId() != null) {
                predicates.add(cb.equal(root.get("id"), filter.getId()));
            }
            if (filter.getName() != null) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.getName().toUpperCase() + "%"));
            }
            if (filter.getAction() != null) {
                predicates.add(cb.equal(root.get("action"), filter.getAction()));
            }
            if (filter.getObject() != null) {
                predicates.add(cb.equal(root.get("object"), filter.getObject()));
            }

            query.distinct(true);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
