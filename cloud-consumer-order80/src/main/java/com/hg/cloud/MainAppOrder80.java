package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 18:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MainAppOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppOrder80.class, args);
    }

}
