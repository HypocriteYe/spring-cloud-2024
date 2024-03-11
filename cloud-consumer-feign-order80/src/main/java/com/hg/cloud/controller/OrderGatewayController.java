package com.hg.cloud.controller;

import com.hg.cloud.api.PayFeignAPI;
import com.hg.cloud.entities.result.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/11 09:57
 */
@RestController
public class OrderGatewayController {
    @Resource
    private PayFeignAPI payFeignAPI;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id) {
        return payFeignAPI.getById(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return payFeignAPI.getGatewayInfo();
    }
}