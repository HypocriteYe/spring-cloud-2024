package com.hg.cloud.api;

import com.hg.cloud.entities.dto.PayDTO;
import com.hg.cloud.entities.result.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/7 16:33
 */
@FeignClient(value = "cloud-payment-service")
public interface PayFeignAPI {

    /**
     * 新增一条支付相关流水记录
     * @param payDTO
     * @return
     */
    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    /**
     * 按照主键记录查询支付流水信息
     * @param id
     * @return
     */
    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);

    /**
     * openfeign天然支持负载均衡演示
     * @return
     */
    @GetMapping(value = "/pay/get/consul")
    public ResultData getInfoFromConsul();

    /**
     * 测试超时调用
     * @return
     */
    @GetMapping("/pay/getTimeOut")
    public ResultData getTimeOut();

    /**
     * Resilience4j CircuitBreaker 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

}
