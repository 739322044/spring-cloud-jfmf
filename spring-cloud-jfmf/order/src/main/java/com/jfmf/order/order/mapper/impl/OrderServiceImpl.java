package com.jfmf.order.order.mapper.impl;

import com.jfmf.order.order.domain.Order;
import com.jfmf.order.order.mapper.OrderMapper;
import com.jfmf.order.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhbr
 * @title: OrderServiceImpl
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/1/611:17
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void saveOrder(Order order) {
        orderMapper.saveOrder(order);

        int sum = order.getSum();
        

    }
}
