package com.daonq1408.memberservice.repository;

import com.daonq1408.memberservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
    boolean existsByName(String name);
}
