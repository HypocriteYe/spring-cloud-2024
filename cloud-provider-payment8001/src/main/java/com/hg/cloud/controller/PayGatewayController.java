package com.hg.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.hg.cloud.entities.dto.PayDTO;
import com.hg.cloud.entities.po.Pay;
import com.hg.cloud.entities.result.ResultData;
import com.hg.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

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

    @GetMapping(value = "/pay/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName +"\t\t\t"+"请求头值: " + headValue);
            if(headName.equalsIgnoreCase("X-Request-hg")) {
                result = result + headName + "\t " + headValue +" ";
            }
        }

        System.out.println("=============================================");
        String customerId = request.getParameter("customerId");
        System.out.println("request Parameter customerId: "+customerId);

        String customerName = request.getParameter("customerName");
        System.out.println("request Parameter customerName: "+customerName);
        System.out.println("=============================================");

        return ResultData.success("getGatewayFilter 过滤器 test： "+result+" \t "+ DateUtil.now());
    }
}