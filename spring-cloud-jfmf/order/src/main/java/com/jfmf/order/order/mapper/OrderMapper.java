package com.jfmf.order.order.mapper;

import com.jfmf.order.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zhbr
 * @title: OrderMapper
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/1/611:17
 */
@Mapper
@Repository
public interface OrderMapper {
    void saveOrder(Order order);
}
