package com.daonq1408.contestservice.repository;

import com.daonq1408.contestservice.entity.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CriterionRepository extends JpaRepository<Criterion,Long>, JpaSpecificationExecutor<Criterion> {
}
