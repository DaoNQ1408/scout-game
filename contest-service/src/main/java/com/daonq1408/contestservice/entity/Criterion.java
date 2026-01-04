package com.daonq1408.contestservice.entity;

import com.daonq1408.contestservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "criteria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Criterion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "point_weight", nullable = false)
    Double pointWeight;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    Status status;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    Challenge challenge;

    @PrePersist
    public void onCreate() {
        if (status == null) {
            status = Status.ACTIVE;
        }
        if (pointWeight == null) {
            pointWeight = 0.0;
        }
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
