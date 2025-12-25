package com.daonq1408.contestservice;

import com.daonq1408.contestservice.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContestServiceApplication {

    public static void main(String[] args) {
        DotEnvConfig.loadEnv();
        SpringApplication.run(ContestServiceApplication.class, args);
    }

}
