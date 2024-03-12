package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/12 19:16
 */
@MapperScan("com.hg.cloud.mapper")
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class MainAppStorage2002 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppStorage2002.class, args);
    }
}
