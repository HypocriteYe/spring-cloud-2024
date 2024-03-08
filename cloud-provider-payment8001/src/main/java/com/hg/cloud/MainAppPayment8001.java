package com.hg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 14:01
 */
@SpringBootApplication
@MapperScan({"com.hg.cloud.mapper"})
@EnableDiscoveryClient
//@RefreshScope // 动态刷新（貌似不需要，配置更新后几秒就会刷新了）
public class MainAppPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(MainAppPayment8001.class, args);
    }

}
