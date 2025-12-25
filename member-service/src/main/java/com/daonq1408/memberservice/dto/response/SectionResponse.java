package com.daonq1408.memberservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SectionResponse {
    Long id;
    String imageUrl;
    String description;
    String code;
    String name;
}
