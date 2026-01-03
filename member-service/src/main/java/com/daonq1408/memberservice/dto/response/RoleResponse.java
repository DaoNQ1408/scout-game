package com.daonq1408.memberservice.dto.response;

import com.daonq1408.memberservice.enums.ScoutElementStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleResponse {
    Long id;
    String name;
    String description;
    LocalDateTime updatedAt;
    ScoutElementStatus status;
}
