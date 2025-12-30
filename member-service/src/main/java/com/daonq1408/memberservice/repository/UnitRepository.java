package com.daonq1408.memberservice.repository;

import com.daonq1408.memberservice.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long>, JpaSpecificationExecutor<Unit> {
    List<Unit> findByParent(Unit parent);
}
