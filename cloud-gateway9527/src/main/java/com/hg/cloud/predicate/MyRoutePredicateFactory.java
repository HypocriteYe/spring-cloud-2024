package com.hg.cloud.predicate;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description 参考AfterRoutePredicateFactory
 * @Author ygl
 * @Create 2024/3/11 11:24
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public static final String USERTYPE_KEY = "userType";

    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    public MyRoutePredicateFactory(Class<Config> configClass) {
        super(configClass);
    }


    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return serverWebExchange -> {
            String userType = serverWebExchange.getRequest().getQueryParams().getFirst(USERTYPE_KEY);
            if (StringUtils.isEmpty(userType)) {
                return false;
            }
            return userType.equals(config.getUserType());
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(USERTYPE_KEY);
    }

    @Data
    public static class Config {

        @NotEmpty
        private String userType;

    }
}
