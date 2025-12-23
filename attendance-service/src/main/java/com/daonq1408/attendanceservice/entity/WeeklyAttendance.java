package com.daonq1408.attendanceservice.entity;

import com.daonq1408.attendanceservice.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "weekly_attendance",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_profile_week_year",
                        columnNames = {"scout_profile_id", "week", "year"}
                )
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WeeklyAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "scout_profile_id", nullable = false)
    Long profileId;

    @Column(name = "week", nullable = false)
    Integer week;

    @Column(name = "year", nullable = false)
    Integer year;

    @Column(name = "is_present", nullable = false)
    Boolean isPresent = false;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    AttendanceStatus status;

    @PrePersist
    protected void onCreate() {
        if (isPresent == null) {
            isPresent = false;
        }
        if (status == null) {
            status = AttendanceStatus.CHANGEABLE;
        }
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
