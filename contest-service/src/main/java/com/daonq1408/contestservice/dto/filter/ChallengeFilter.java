package com.daonq1408.contestservice.dto.filter;

import com.daonq1408.contestservice.enums.Status;
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
public class ChallengeFilter {
    Long id;
    String name;
    String description;
    Status status;
    Long contestId;
    Long rankId;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
