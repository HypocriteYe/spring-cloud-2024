package com.hg.cloud.service;

import com.hg.cloud.entities.po.Pay;
import com.hg.cloud.entities.dto.PayDTO;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 14:07
 */
public interface PayService {

    int add(PayDTO payDTO);
    int delete(Integer id);
    int update(PayDTO payDTO);

    PayDTO getPayById(Integer id);

    List<PayDTO> getPayList();

    Pay testPay();
}
