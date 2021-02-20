package com.jfmf.product.product.controller;

import com.jfmf.product.product.domain.Product;
import com.jfmf.product.product.service.ProductService;
import com.jfmf.product.product.util.Code;
import com.jfmf.product.product.util.Result;
import com.jfmf.product.product.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author zhbr
 * @title: ProductController
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/129:18
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/dota2")
    @ResponseBody
    public Result dota2(String player){
        return ResultUtil.success(player+"play dota2,go！！！");
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Product product){
        String uuid = UUID.randomUUID().toString();
        product.setId(uuid);
        product.setProductName("pro测试"+new Random().nextDouble());
        try {
            productService.save(product);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("执行新增报错");
        }
        return ResultUtil.success(productService.save(product));
    }

    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody Product product){
        return ResultUtil.success(productService.delete(product));
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Product product){
        return ResultUtil.success(productService.update(product));
    }

    @PostMapping("/getProductList")
    @ResponseBody
    public Result getProductList(@RequestBody Product product){
        List<Product> productList = productService.getProductList(product);
        return ResultUtil.success(productList);
    }

    /***
    	 * 获取商品信息
    	 * @author yangfeng
    	 * @date 2021/1/6
    	 * @return com.jfmf.product.product.util.Result
    	 *
    	 */
    @PostMapping("/selectProductInfoList")
    @ResponseBody
    public Result selectProductInfoList(@RequestBody Product product){
        List<Product> productList = productService.selectProductInfoList(product);
        return ResultUtil.success(productList);
    }
    /***
    	 * 出库，入库:更新商品数量
    	 * @author yangfeng
    	 * @date 2021/1/6
    	 * @return com.jfmf.product.product.util.Result
    	 *
    	 */
    @PostMapping("/setProductNum")
    @ResponseBody
    public Result setProductNum(@RequestBody Product product){
        try{
            productService.setProductNum(product);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.fail(Code.FAIL_DATABASE,e.getMessage());
        }


    }






}
