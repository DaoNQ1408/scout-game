package com.daonq1408.memberservice.specification;

import com.daonq1408.memberservice.dto.request.filter.RoleRequestFilter;
import com.daonq1408.memberservice.entity.Role;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RoleSpec {

    public static Specification<Role> filter(RoleRequestFilter filter){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getId() != null) {
                predicates.add(cb.equal(root.get("id"), filter.getId()));
            }
            if (filter.getName() != null) {
                predicates.add(cb.like(cb.upper(root.get("name")), "%" + filter.getName().toUpperCase() + "%"));
            }
            if (filter.getStatus() != null) {
                predicates.add(cb.equal(root.get("status"), filter.getStatus()));
            }

            query.distinct(true);

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
