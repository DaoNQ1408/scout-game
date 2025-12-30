package com.daonq1408.memberservice.dto.request;

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
public class UnitRequest {
    String name;
    String code;
    String imageUrl;
    String description;
    long sectionId;
    Long parentUnitId;
    UnitLevel unitLevel;
}
