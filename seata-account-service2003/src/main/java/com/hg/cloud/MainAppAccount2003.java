package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/12 19:14
 */
@MapperScan("com.hg.cloud.mapper")
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class MainAppAccount2003 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppAccount2003.class, args);
    }
}
