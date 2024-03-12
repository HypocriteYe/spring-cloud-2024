package com.hg.cloud.api.fallback;

import com.hg.cloud.api.PayFeignSentinelAPI;
import com.hg.cloud.entities.enums.ReturnCodeEnum;
import com.hg.cloud.entities.result.ResultData;
import org.springframework.stereotype.Component;

//@Component
public class PayFeignSentinelAPIFallBack implements PayFeignSentinelAPI {
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}