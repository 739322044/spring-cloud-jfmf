package com.jfmf.order.order.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.annotations.Table;

import java.math.BigDecimal;

/**
 * @author zhbr
 * @title: Order
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/1/610:53
 */
@TableName("product")
@Data
public class Order {


    @TableId( value = "id",type = IdType.AUTO)
    private String id;
    @TableField(value = "consumer_id")
    private String consumerId;
    @TableField(value = "product_id")
    private String  productId;
    @TableField(value = "amonut")
    private BigDecimal amonut;
    @TableField(value = "status")
    private String status;
    @TableField(value = "sum")
    private int sum;


}
