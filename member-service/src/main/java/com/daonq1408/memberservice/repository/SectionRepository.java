package com.daonq1408.memberservice.repository;

import com.daonq1408.memberservice.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SectionRepository extends JpaRepository<Section,Long>, JpaSpecificationExecutor<Section> {
}
