package com.hg.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.hg.cloud.entities.dto.PayDTO;
import com.hg.cloud.entities.po.Pay;
import com.hg.cloud.entities.result.ResultData;
import com.hg.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PayGatewayController {
    @Resource
    PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<PayDTO> getById(@PathVariable("id") Integer id) {
        PayDTO pay = payService.getPayById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        log.info("getGatewayInfo");
        return ResultData.success("gateway info test：" + IdUtil.simpleUUID());
    }
}