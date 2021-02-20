package com.jfmf.product.product.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


/**
 * @author zhbr
 * @title: Product
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/129:18
 */
@TableName("product")
@Data
public class Product {
    @TableId(value = "id", type = IdType.AUTO)
    private String id ;
    @TableField(value = "product_name")
    private String productName;
    @TableField(value = "product_type")
    private String productType;
    @TableField(value = "product_price")
    private String productPrice;
    @TableField(value = "product_valid")
    private String productValid;
    @TableField(value = "product_num")
    private String productNum;

}
