package com.hg.cloud.api;

import com.hg.cloud.api.fallback.PayFeignSentinelAPIFallBack;
import com.hg.cloud.entities.result.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelAPIFallBack.class)
public interface PayFeignSentinelAPI {
    @GetMapping("/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
 