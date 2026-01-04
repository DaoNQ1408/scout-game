package com.daonq1408.contestservice.entity;

import com.daonq1408.contestservice.enums.ContestFormat;
import com.daonq1408.contestservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "contests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "description", columnDefinition = "TEXT")
    String description;

    @Column(name = "count_in_season", nullable = false)
    Integer countInSeason;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "format", nullable = false)
    ContestFormat format;

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
