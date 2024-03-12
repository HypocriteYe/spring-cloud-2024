package com.hg.cloud.service;

import com.hg.cloud.pojo.entities.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);

}