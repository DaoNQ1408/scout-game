package com.daonq1408.memberservice.entity;

import com.daonq1408.memberservice.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "scout_profiles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Scout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name= "code", nullable = false, length = 10, unique = true)
    String code;

    @Column(name= "full_name", nullable = false, length = 50)
    String fullName;

    @Column(name = "phone", length = 10, unique = true)
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "dob", nullable = false)
    Date dob;

    @Column(name = "citizen_id", nullable = false, unique = true, length = 12)
    String citizenId;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    ProfileStatus status;

    @OneToMany(mappedBy = "scout", fetch = FetchType.LAZY)
    List<ProfileDetail> profileDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "scouts_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "user_profile_id", nullable = false, unique = true)
    User user;

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

    public Set<String> getAllPermissionNames() {
        Set<String> perms = new HashSet<>();
        for (Role role : roles) {
            for (Permission p : role.getPermissions()) {
                perms.add(p.getName());
            }
        }
        return perms;
    }
}
