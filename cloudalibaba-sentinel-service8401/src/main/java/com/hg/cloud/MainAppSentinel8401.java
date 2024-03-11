package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/11 19:03
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainAppSentinel8401 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppSentinel8401.class, args);
    }
}
