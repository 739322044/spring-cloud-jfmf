package com.jfmf.product.product.util;

/**
 * @author zhbr
 * @title: Code
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/1011:02
 */
public enum Code {

    SUCCESS(100,"执行成功"),
    FAIL_PARAM(200,"参数异常"),
    FAIL_DATABASE(300,"数据库执行报错"),
    FAIL_SERVER(400,"调用服务报错");

    public Integer status;
    public String message;
    Code (Integer integer,String mess){
        this.status = integer;
        this.message = mess;
    }

}
