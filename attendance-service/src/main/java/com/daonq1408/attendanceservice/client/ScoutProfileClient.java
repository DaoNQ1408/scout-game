package com.daonq1408.attendanceservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "member-service",
        path = "/scout-profiles"
)
public interface ScoutProfileClient {

    @GetMapping
    List<Long> getActiveScoutProfileIds();
}
