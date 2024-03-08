package com.hg.cloud.service.impl;

import com.hg.cloud.converter.PayConverter;
import com.hg.cloud.entities.po.Pay;
import com.hg.cloud.entities.dto.PayDTO;
import com.hg.cloud.mapper.PayMapper;
import com.hg.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @Author ygl
 * @Create 2024/3/6 14:08
 */
@Slf4j
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayConverter payConverter;

    @Resource
    private PayMapper payMapper;

    @Override
    public int add(PayDTO payDTO) {
        return payMapper.insertSelective(payConverter.convert(payDTO));
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(PayDTO payDTO) {
        return payMapper.updateByPrimaryKeySelective(payConverter.convert(payDTO));
    }

    @Override
    public PayDTO getPayById(Integer id) {
        return payConverter.convert(payMapper.selectByPrimaryKey(id));
    }

    @Override
    public List<PayDTO> getPayList() {
        return payConverter.convert(payMapper.selectAll());
    }

    @Override
    public Pay testPay() {
        return new Pay();
    }
}
