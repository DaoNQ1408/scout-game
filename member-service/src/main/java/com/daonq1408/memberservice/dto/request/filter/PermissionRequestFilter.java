package com.daonq1408.memberservice.dto.request.filter;

import com.daonq1408.memberservice.enums.PermissionAction;
import com.daonq1408.memberservice.enums.PermissionObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionRequestFilter {
    Long id;
    String name;
    PermissionAction action;
    PermissionObject object;
}
