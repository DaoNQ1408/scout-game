package com.daonq1408.contestservice.dto.filter;

import com.daonq1408.contestservice.enums.ContestCycle;
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
public class ContestTypeFilter {
    Long id;
    String description;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Status status;
    ContestCycle cycle;
}
