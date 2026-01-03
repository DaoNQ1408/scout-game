package com.daonq1408.memberservice.dto.response;

import com.daonq1408.memberservice.enums.PermissionAction;
import com.daonq1408.memberservice.enums.PermissionObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionResponse {
    Long id;
    String name;
    String description;
    PermissionAction action;
    PermissionObject object;
}
