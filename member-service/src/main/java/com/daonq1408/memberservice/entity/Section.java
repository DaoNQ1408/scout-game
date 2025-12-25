package com.daonq1408.memberservice.entity;

import com.daonq1408.memberservice.enums.ProfileStatus;
import com.daonq1408.memberservice.enums.ScoutElementStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sections")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Section { // ngành

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, length = 50)
    String name;

    @Column(name= "code", nullable = false, length = 10, unique = true)
    String code;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "description")
    String description;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    ScoutElementStatus status;

    @OneToMany(mappedBy = "section", fetch = FetchType.LAZY)
    List<Rank> ranks;

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
