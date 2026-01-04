package com.daonq1408.contestservice.dto.response;

import com.daonq1408.contestservice.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChallengeResponse {
    Long id;
    String title;
    String description;
    Long contestId;
    Long rankId;
    Status status;
}
