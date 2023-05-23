package com.nexus.drone.drone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NexusDroneDroneApplication {

    public static void main(String[] args) {
        SpringApplication.run(NexusDroneDroneApplication.class, args);
    }

}
