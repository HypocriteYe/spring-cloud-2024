package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/11 15:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainAppOrder83 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppOrder83.class, args);
    }
}
