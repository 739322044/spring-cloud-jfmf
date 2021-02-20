package com.jfmf.gateway;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zhbr
 * @title: FallBackCmd
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/115:08
 */
@RestController
public class FallBackCmd {

    @GetMapping("/fallbackConsumer")
    @ResponseBody
    public HashMap fallbackConsumer(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("status",100);
        map.put("message","消费者模块繁忙，请稍后重试。。。");
        return map;

    }

}
