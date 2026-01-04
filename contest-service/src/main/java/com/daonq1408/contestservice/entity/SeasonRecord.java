package com.daonq1408.contestservice.entity;

import com.daonq1408.contestservice.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "season_records")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeasonRecord { // giống bxh sau từng contest

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "challenge_point", nullable = false)
    Double challengePoint;

    @Column(name = "total_point", nullable = false)
    Double totalPoint;

    @Column(name = "place_holder", nullable = false)
    Integer placeHolder;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    Status status;

    @ManyToOne
    @JoinColumn(name = "contest_id", nullable = false)
    Contest contest;

    @Column(name = "scout_profile_id", nullable = false)
    Long scoutId;

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
