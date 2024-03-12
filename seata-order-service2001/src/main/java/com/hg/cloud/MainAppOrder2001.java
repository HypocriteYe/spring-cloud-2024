package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/12 19:15
 */
@MapperScan("com.hg.cloud.mapper")
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class MainAppOrder2001 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppOrder2001.class, args);
    }
}
