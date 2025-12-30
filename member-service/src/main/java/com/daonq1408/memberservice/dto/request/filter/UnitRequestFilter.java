package com.daonq1408.memberservice.dto.request.filter;

import com.daonq1408.memberservice.enums.ScoutElementStatus;
import com.daonq1408.memberservice.enums.UnitLevel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnitRequestFilter {
    Long id;
    String name;
    String code;
    Long sectionId;
    Long parentUnitId;
    ScoutElementStatus status;
    UnitLevel level;
}
