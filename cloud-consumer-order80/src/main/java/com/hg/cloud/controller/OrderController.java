package com.hg.cloud.controller;

import com.alibaba.fastjson2.JSON;
import com.hg.cloud.entities.dto.PayDTO;
import com.hg.cloud.entities.result.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 18:16
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/{id}", ResultData.class, id);
    }

    @GetMapping("/consumer/pay/getList")
    public ResultData getPayList() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/getList", ResultData.class);
    }

    @PutMapping("/consumer/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_URL + "/pay/update", payDTO, ResultData.class);
    }

    @GetMapping("/consumer/get/consul")
    public ResultData getInfoFromConsul() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/consul", ResultData.class);
    }

    @GetMapping("/consumer/discovery")
    public ResultData<List<String>> discovery() {
        List<String> clientList = new ArrayList<>();
        for (String service : discoveryClient.getServices()) {
            clientList.add(JSON.toJSONString(discoveryClient.getInstances(service)));
        }

        return ResultData.success(clientList);
    }
}
