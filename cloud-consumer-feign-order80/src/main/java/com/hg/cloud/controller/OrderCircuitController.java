package com.hg.cloud.controller;

import com.hg.cloud.api.PayFeignAPI;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.apache.hc.core5.concurrent.CompletedFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/8 15:40
 */
@RestController
public class OrderCircuitController {

    @Resource
    private PayFeignAPI payFeignAPI;

    @GetMapping(value = "/feign/pay/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String myCircuitBreaker(@PathVariable("id") Integer id) {

        return payFeignAPI.myCircuit(id);
    }

    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service", fallbackMethod = "myBulkheadFallback", type = Bulkhead.Type.SEMAPHORE)
    public String myBulkheadBreaker(@PathVariable("id") Integer id) {
        return payFeignAPI.myBulkhead(id);
    }

    @GetMapping(value = "/feign/pay/bulkheadpool/{id}")
    @Bulkhead(name = "cloud-payment-service", fallbackMethod = "myBulkheadPoolFallback", type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> myBulkheadPoolBreaker(@PathVariable("id") Integer id) {
        System.out.println("开始进入BulkheadPool");
        try {
            Thread.sleep(3000);
        } catch (Exception ignored) {}
        System.out.println("结束进入BulkheadPool");
        return CompletableFuture.supplyAsync(() -> payFeignAPI.myBulkhead(id) + "\t" + Bulkhead.Type.THREADPOOL);
    }

    @GetMapping(value = "/feign/pay/ratelimit/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myRateLimitFallback")
    public String myBulkhead(@PathVariable("id") Integer id)
    {
        return payFeignAPI.myRateLimit(id);
    }
    public String myRateLimitFallback(Integer id,Throwable t)
    {
        return "你被限流了，禁止访问/(ㄒoㄒ)/~~";
    }



    //myCircuitFallback就是服务降级后的兜底处理方法
    public String myCircuitFallback(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }


    public String myBulkheadFallback(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myBulkheadFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

    public CompletableFuture<String> myBulkheadPoolFallback(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return CompletableFuture.supplyAsync(() -> "myBulkheadPoolFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }
}
