package com.jfmf.product.product.service;

import com.jfmf.product.product.domain.Product;
import com.jfmf.product.product.util.Result;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhbr
 * @title: ProductService
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/129:32
 */
public interface ProductService {
    Integer save( Product product);
    Integer update( Product product);
    Integer delete( Product product);
    List<Product> getProductList(Product product);
    List<Product> selectProductInfoList(Product product);
    void setProductNum(Product product);
}
