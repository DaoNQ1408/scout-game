package com.daonq1408.contestservice.dto.filter;

import com.daonq1408.contestservice.enums.ContestFormat;
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
public class ContestFilter {
    Long id;
    String description;
    Integer countInSeason;
    ContestFormat format;
    Long seasonId;
    Long contestTypeId;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
