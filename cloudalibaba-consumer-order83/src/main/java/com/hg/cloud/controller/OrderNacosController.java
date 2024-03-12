package com.hg.cloud.controller;

import com.hg.cloud.api.PayFeignSentinelAPI;
import com.hg.cloud.entities.result.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableFeignClients
@Slf4j
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PayFeignSentinelAPI payFeignSentinelAPI;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = restTemplate.getForObject(serverURL + "/pay/nacos/" + id, String.class);
        return result + "\t" + "    我是OrderNacosController83调用者。。。。。。";
    }

    @GetMapping(value = "/consumer/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo) {
        log.info("getPayByOrderNo: {}", orderNo);
        return payFeignSentinelAPI.getPayByOrderNo(orderNo);
    }
}