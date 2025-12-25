package com.daonq1408.attendanceservice.dto.api;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageMeta {
    int currentPage;
    int size;
    int lastPage;
    long totalElements;
}
