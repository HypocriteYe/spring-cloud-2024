package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/11 15:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainAppPayment9001 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppPayment9001.class, args);
    }
}
