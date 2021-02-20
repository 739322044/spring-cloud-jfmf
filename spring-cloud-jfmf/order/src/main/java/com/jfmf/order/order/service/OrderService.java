package com.jfmf.order.order.service;

import com.jfmf.order.order.domain.Order;

/**
 * @author zhbr
 * @title: OrderService
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/1/611:17
 */

public interface OrderService {
    void saveOrder(Order order);
}
