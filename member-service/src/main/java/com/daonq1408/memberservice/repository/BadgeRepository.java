package com.daonq1408.memberservice.repository;

import com.daonq1408.memberservice.entity.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BadgeRepository extends JpaRepository<Badge, Long>, JpaSpecificationExecutor<Badge> {
}
