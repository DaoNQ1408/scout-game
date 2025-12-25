package com.daonq1408.memberservice.entity;

import com.daonq1408.memberservice.enums.ProfileDetailType;
import com.daonq1408.memberservice.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "profile_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "actual_date", nullable = false)
    LocalDate actualDate;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    ProfileStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    ProfileDetailType type;

    @ManyToOne
    @JoinColumn(name = "scout_profile_id", nullable = false)
    Scout scout;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    Unit unit;

    @ManyToOne
    @JoinColumn(name = "rank_id")
    Rank rank;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    Badge badge;

    @PrePersist
    public void onCreate() {
        if (status == null) {
            status = ProfileStatus.ACTIVE;
        }
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
