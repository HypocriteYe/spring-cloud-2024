package com.hg.cloud.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/11 13:42
 */
@Slf4j
@Component
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

    public static final String MY_STATUS = "myStatus";

    public MyGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("进入了自定义网关过滤器MyGatewayFilterFactory，status: " + config.getMyStatus());
            if (request.getQueryParams().containsKey(config.getMyStatus())) {
                return chain.filter(exchange);
            } else {
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(MY_STATUS);
    }

    @Data
    public static class Config {

        private String myStatus;
    }
}
