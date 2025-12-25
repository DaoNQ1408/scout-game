package com.daonq1408.discoveryserver;

import com.daonq1408.discoveryserver.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

    public static void main(String[] args) {
        DotEnvConfig.loadEnv();
        SpringApplication.run(DiscoveryServerApplication.class, args);
    }

}
