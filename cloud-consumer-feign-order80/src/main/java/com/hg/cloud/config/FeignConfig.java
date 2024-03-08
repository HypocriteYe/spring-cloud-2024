package com.hg.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/8 10:57
 */
@Configuration
public class FeignConfig {

//    @Bean
//    public Retryer retryer() {
//        return new Retryer.Default(100, 1, 3);
//    }
//
//    @Bean
//    public Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }
}
