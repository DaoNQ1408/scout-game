package com.daonq1408.contestservice.repository;

import com.daonq1408.contestservice.entity.SeasonRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SeasonRecordRepository extends JpaRepository<SeasonRecord,Long>, JpaSpecificationExecutor<SeasonRecord> {
}
