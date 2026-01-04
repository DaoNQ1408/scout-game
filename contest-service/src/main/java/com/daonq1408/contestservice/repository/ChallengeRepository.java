package com.daonq1408.contestservice.repository;

import com.daonq1408.contestservice.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChallengeRepository extends JpaRepository<Challenge,Long>, JpaSpecificationExecutor<Challenge> {
}
