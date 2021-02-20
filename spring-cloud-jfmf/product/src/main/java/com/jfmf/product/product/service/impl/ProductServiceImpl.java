package com.jfmf.product.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfmf.product.product.domain.Product;
import com.jfmf.product.product.mapper.ProductMapper;
import com.jfmf.product.product.service.ProductService;
import com.jfmf.product.product.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhbr
 * @title: ProductServiceImpl
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/129:33
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Integer save(Product product) {
        return productMapper.save(product);
    }

    @Override
    public Integer update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public Integer delete(Product product) {
        //根据id删除


        return productMapper.delete(product);
    }

    @Override
    public List<Product> getProductList(Product product) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("product_name",product.getProductName());


        List<Product> products = productMapper.selectList(queryWrapper);
        return  products;
    }

    @Override
    public List<Product> selectProductInfoList(Product product) {

        return productMapper.selectProductInfoList(product);
    }

    @Override
    public void setProductNum(Product product) {

    }
}
