package com.daonq1408.memberservice.dto.response;

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
public class RankResponse {
    Long id;
    String imageUrl;
    String description;
    String code;
    String name;
    LocalDateTime updatedAt;
}
