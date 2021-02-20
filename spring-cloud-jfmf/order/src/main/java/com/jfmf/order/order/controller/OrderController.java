package com.jfmf.order.order.controller;

import com.jfmf.order.order.domain.Order;
import com.jfmf.order.order.service.OrderService;
import com.jfmf.order.order.util.Result;
import com.jfmf.order.order.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhbr
 * @title: OrderController
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/1/610:52
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @PostMapping("/saveOrder")
    public Result saveOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResultUtil.success();
    }

}
