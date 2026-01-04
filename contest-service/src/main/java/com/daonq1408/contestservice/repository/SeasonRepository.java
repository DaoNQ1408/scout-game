package com.daonq1408.contestservice.repository;

import com.daonq1408.contestservice.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeasonRepository extends JpaRepository<Season,Long>, JpaSpecificationExecutor<Season> {
}
