package com.hg.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/11 13:24
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    public static final String BEGIN_TIME = "beginTime";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        exchange.getAttributes().put(BEGIN_TIME, System.currentTimeMillis());

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long beginTime = exchange.getAttribute(BEGIN_TIME);
            if (!ObjectUtils.isEmpty(beginTime)) {
                log.info("访问接口主机: " + exchange.getRequest().getURI().getHost());
                log.info("访问接口端口: " + exchange.getRequest().getURI().getPort());
                log.info("访问接口URL: " + exchange.getRequest().getURI().getPath());
                log.info("访问接口URL参数: " + exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口时长: " + (System.currentTimeMillis() - beginTime) + "ms");
                log.info("我是美丽分割线: ###################################################");
                System.out.println();
            }
        }));
    }


    /**
     * 数组越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
