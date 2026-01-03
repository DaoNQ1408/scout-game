package com.daonq1408.memberservice.entity;

import com.daonq1408.memberservice.enums.PermissionAction;
import com.daonq1408.memberservice.enums.PermissionObject;
import com.daonq1408.memberservice.enums.ScoutElementStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "permissions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, length = 50)
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    ScoutElementStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "action", nullable = false)
    PermissionAction action;

    @Enumerated(EnumType.STRING)
    @Column(name = "object", nullable = false)
    PermissionObject object;

    @PrePersist
    public void onCreate() {
        if (status == null) {
            status = ScoutElementStatus.ACTIVE;
        }
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
