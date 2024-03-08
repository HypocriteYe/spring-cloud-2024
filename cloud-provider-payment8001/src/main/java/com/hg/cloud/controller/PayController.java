package com.hg.cloud.controller;

import com.alibaba.fastjson2.JSON;
import com.hg.cloud.entities.dto.PayDTO;
import com.hg.cloud.entities.result.ResultData;
import com.hg.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 14:13
 */
@RequestMapping("/pay")
@RestController
@Tag(name = "支付微服务模块", description = "支付CRUD")
@Slf4j
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/add")
    @Operation(summary = "添加支付记录")
    public ResultData<Integer> addPay(@RequestBody PayDTO payDTO) {
        log.info("addPay: {}", JSON.toJSONString(payDTO));
        int i = payService.add(payDTO);
        return ResultData.success(i);
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "删除支付记录")
    public ResultData<Integer> delete(@PathVariable("id") Integer id) {
        log.info("delete: {}", id);
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "根据id查询支付记录")
    public ResultData<PayDTO> getPayInfo(@PathVariable("id") Integer id) {
        log.info("getPay: {}", id);
        PayDTO pay = payService.getPayById(id);
        return ResultData.success(pay);
    }

    @GetMapping("/getList")
    @Operation(summary = "查询所有支付记录")
    public ResultData<List<PayDTO>> getPayList() {
        List<PayDTO> payList = payService.getPayList();
        return ResultData.success(payList);
    }

    @PutMapping("/update")
    @Operation(summary = "更新支付记录")
    public ResultData<Integer> updatePay(@RequestBody PayDTO payDTO) {
        log.info("updatePay: {}", JSON.toJSONString(payDTO));
        int i = payService.update(payDTO);
        return ResultData.success(i);
    }

    @GetMapping("/test")
    public ResultData test() {
        int i = 10 / 0;
        return ResultData.success();
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/consul")
    public ResultData getInfoFromConsul(@Value("${hg.info}") String info) {
        return ResultData.success("port: " + port + ", info: " + info);
    }

    @GetMapping("/getTimeOut")
    public ResultData getTimeOut() {
        try {
            log.info("wait ... wait ... ");
            Thread.sleep(62000);
            log.info("wait ... finished ... ");
        } catch (Exception ignored) {}
        return ResultData.success();
    }
}
