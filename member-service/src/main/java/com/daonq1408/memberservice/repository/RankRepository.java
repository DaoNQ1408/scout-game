package com.daonq1408.memberservice.repository;

import com.daonq1408.memberservice.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RankRepository extends JpaRepository<Rank,Integer>, JpaSpecificationExecutor<Rank> {
    Optional<Rank> findById(Long id);
}
