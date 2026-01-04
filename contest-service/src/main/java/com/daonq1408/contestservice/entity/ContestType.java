package com.daonq1408.contestservice.entity;

import com.daonq1408.contestservice.enums.ContestCycle;
import com.daonq1408.contestservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "contest_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "cycle", nullable = false)
    ContestCycle cycle;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    Status status;

    @PrePersist
    public void onCreate() {
        if (status == null) {
            status = Status.ACTIVE;
        }
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
