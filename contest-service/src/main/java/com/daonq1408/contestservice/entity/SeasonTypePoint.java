package com.daonq1408.contestservice.entity;

import com.daonq1408.contestservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "season_type_points",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_type_point_per_season",
                        columnNames = {"season_id", "contest_type_id"}
                )
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeasonTypePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    Status status;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    Season season;

    @ManyToOne
    @JoinColumn(name = "contest_type_id", nullable = false)
    ContestType type;

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
