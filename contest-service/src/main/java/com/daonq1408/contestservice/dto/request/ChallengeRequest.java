package com.daonq1408.contestservice.dto.request;

import com.daonq1408.contestservice.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChallengeRequest {
    String title;
    String description;
    Long contestId;
    Long rankId;
    Status status;
}
