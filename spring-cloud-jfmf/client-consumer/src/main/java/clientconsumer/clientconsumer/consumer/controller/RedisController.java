package clientconsumer.clientconsumer.consumer.controller;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import clientconsumer.clientconsumer.consumer.service.ConsumerService;
import clientconsumer.clientconsumer.consumer.vo.UserVo;
import clientconsumer.clientconsumer.util.RedisUtil;
import clientconsumer.clientconsumer.util.Result;
import clientconsumer.clientconsumer.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhbr
 * @title: RedisController
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/2914:51
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private ConsumerService consumerService;


    @ResponseBody
    @GetMapping("/getName")
    public Result getName(String name){
//        Object name1 = RedisUtil.get("name");
        Consumer consumer = new Consumer();
        consumer.setName(name);
        RedisUtil.hmSet("consumer",consumer.hashCode()+"0",consumer);
        RedisUtil.hmSet("consumer",consumer.hashCode()+"1",consumer.getName());
        return ResultUtil.success("你好！"+name);
    }

    @ResponseBody
    @PostMapping("/getConsumer")
    //@Cacheable(key = "'getConsumer'+#consumer" ,value = "yf")
    //@Cacheable(key = "'getConsumer'+target+'_'+method" ,value = "yf")
    @Cacheable(key = "'getConsumer_'+#consumer.getName()",value = "yf")
    public List<UserVo> getName(@RequestBody Consumer consumer){
        List<UserVo> userList = consumerService.getUserList(consumer);
        System.out.println("你好！"+consumer.getName());
        return userList;
    }

    @ResponseBody
    @PostMapping("/getConsumer1")
    @CachePut(key = "'getConsumer'+#consumer.getId()" ,value = "yf")
    public List<UserVo> getName1(@RequestBody Consumer consumer){
        List<UserVo> userList = consumerService.getUserList(consumer);
        System.out.println("你好！"+consumer.getName());
        return userList;
    }
    @ResponseBody
    @PostMapping("/getConsumer2")
    @CacheEvict(key = "'getConsumer'+#consumer.getId()" ,value = "yf")
    public void getName2(@RequestBody Consumer consumer){
        System.out.println("进行删除...");
    }






}
