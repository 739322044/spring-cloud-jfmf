package com.jfmf.product.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfmf.product.product.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhbr
 * @title: ProductMapper
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/129:18
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    Integer save(Product product);
    Integer update(Product product);
    Integer delete(Product product);

    List<Product> selectProductInfoList(Product product);
    void setProductNum(Product product);
}
