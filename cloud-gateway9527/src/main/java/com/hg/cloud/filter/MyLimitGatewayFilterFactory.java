package com.hg.cloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/11 14:19
 */
public class MyLimitGatewayFilterFactory extends AbstractGatewayFilterFactory<MyLimitGatewayFilterFactory.Config> {

    public static final String LIMIT_PARAM_NAME = "limit";

    public MyLimitGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return null;
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return super.shortcutFieldOrder();
    }

    public static class Config {
    }
}
