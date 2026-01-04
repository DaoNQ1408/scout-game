package com.daonq1408.contestservice.repository;

import com.daonq1408.contestservice.entity.SeasonTypePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeasonTypePointRepository extends JpaRepository<SeasonTypePoint,Long>, JpaSpecificationExecutor<SeasonTypePoint> {
}
