package com.daonq1408.memberservice;

import com.daonq1408.memberservice.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemberServiceApplication {

    public static void main(String[] args) {
        DotEnvConfig.loadEnv();
        SpringApplication.run(MemberServiceApplication.class, args);
    }
}
