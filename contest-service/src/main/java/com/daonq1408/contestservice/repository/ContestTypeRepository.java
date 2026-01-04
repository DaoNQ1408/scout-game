package com.daonq1408.contestservice.repository;

import com.daonq1408.contestservice.entity.ContestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContestTypeRepository extends JpaRepository<ContestType,Long>, JpaSpecificationExecutor<ContestType> {
}
