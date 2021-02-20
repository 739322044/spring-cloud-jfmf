package clientconsumer.clientconsumer.consumer.controller;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import clientconsumer.clientconsumer.consumer.domain.Job;
import clientconsumer.clientconsumer.consumer.mapper.UserMapper;
import clientconsumer.clientconsumer.consumer.service.ConsumerService;
import clientconsumer.clientconsumer.consumer.vo.ConsumerVo;
import clientconsumer.clientconsumer.consumer.vo.JobVo;
import clientconsumer.clientconsumer.consumer.vo.UserVo;
import clientconsumer.clientconsumer.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhbr
 * @title: ConsumerController
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/611:26
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {
    //已经出售的票数
    //private volatile AtomicInteger count = new AtomicInteger(0);
    private  int count = 0;
    //总共有多少张票
    private  int sum = 50;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpClientUtil httpClientUtil;

    //测试post跨服务调用
    @GetMapping("/hello")
    public String hello() {

        Consumer consumer = new Consumer();
        consumer.setName("考神");
        consumer.setId(5);
        //修改本地服务的数据
        userMapper.updateConsumer(consumer);


        Map<String, Object> map = new HashMap<>();
        map.put("productPrice", "123.32");
        map.put("productName", "护手霜");
        String url = "http://product/product/save";
        Result result = httpClientUtil.doPost(url, map, "");
        return result.toString();
    }

    //测试get跨服务调用
    @GetMapping("/hi")
    @ResponseBody
    public String hi() {
        String url = "http://product/product/dota2";
        Map map = new HashMap<String, String>();
        map.put("player", "miracle");
        Result result = httpClientUtil.doGet(url, map, "");
        return result.toString();
    }

    /***
     * 测试 单个服务中的事务控制
     * @author yangfeng
     * @date 2020/12/12
     * @param
     * @return clientconsumer.clientconsumer.util.Result
     */
    @ResponseBody
    @PostMapping("/transactionalTest")
    @Transactional()
    public Result transactionalTest(@RequestBody Consumer consumer) {

        List<Map<String, Object>> list = new ArrayList<>();
        List<Map<String, Object>> list2 = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "1");
        Map<String, Object> map2 = new HashMap<>();

        userMapper.selectList(map1);
        map2.put("id", "2");
        list.add(map1);
        list.add(map2);

        userMapper.selectList(list);

        Collections.copy(list, list2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", "3");
        list2.add(map3);
        userMapper.selectList(list, list2);

        try {
            userMapper.updateAme(consumer);
            for (int i = 0; i < 3; i++) {
                new Thread(() -> {
                    int a = 1 / 0;
                }).start();
            }
            Thread.sleep(5000);
            userMapper.updateJobDes(consumer);
        } catch (Exception e) {
            log.error("报错===" + e.getMessage());

            //throw new RuntimeException();
        }
        return ResultUtil.success();
    }

    @Transactional
    public void A(Consumer consumer) {
        userMapper.updateAme(consumer);
        B(consumer);
    }

    @Transactional
    public void B(Consumer consumer) {
        int a = 1 / 0;
        userMapper.updateJobDes(consumer);
    }


    @PostMapping("/practiseSeata")
    @ResponseBody
    public Result practiseSeata(@RequestBody Consumer consumer) {
        userMapper.updateAme(consumer);

        Map<String, Object> map = new HashMap<>();
        map.put("productPrice", "123.32");
        map.put("productName", "护手霜");
        String url = "http://product/product/save";
        Result result = httpClientUtil.doPost(url, map, "");
        return result;
    }

    /***
     * 练习 服务中的多线程
     * @author yangfeng
     * @date 2020/12/14
     */
    @ResponseBody
    @PostMapping("/practiseThread")
    public Result practiseThread() {

        for (int i = 0; i < 3 ; i++) {
            new Thread(() -> {
                for (int j = 0; j < sum; j++) {
                    if (count<sum){
                        count++;
                        System.out.println(Thread.currentThread().getName()+"出售一张门票，目前累计出售"+count+" 张门票");
                    }
                }
            }).start();
        }
        return ResultUtil.success("asfdasdfasdf");
    }

    /***
     * 练习 服务中的redis
     * @author yangfeng
     * @date 2020/12/14
     */
    @ResponseBody
    @PostMapping("/practiseRedis")
    public Object practiseRedis() throws InterruptedException {
        RedisUtil.set("name","haha");
        Thread.sleep(3500);
        Object name = RedisUtil.get("name");
        return name;
        //return ResultUtil.success(RedisUtil.get("name"));
    }
    @ResponseBody
    @PostMapping("/practiseRedis1")
    //@CachePut(key = "'name'", value = "yf")
    @Cacheable(key = "'name'", value = "yf")
    public String practiseRedis1(@RequestBody Consumer consumer) throws InterruptedException {
        return consumer.getName();
        //return ResultUtil.success(RedisUtil.get("name"));
    }

    @PostMapping("/selectPubOrgan")
    @ResponseBody
    public Result oracleTest(String deptName) {
        List<String> list = userMapper.selectPubOrgan(deptName);
        return ResultUtil.success(list);
    }

    /***
     * 练习association 查询顾客信息
     * @author yangfeng
     * @date 2020/12/9
     * @param
     * @return clientconsumer.clientconsumer.util.Result
     *
     */
    @ResponseBody
    @PostMapping("/getConsumerVoList")
    public Result getConsumerVoList(@RequestBody Consumer consumer) {
        List<ConsumerVo> consumerVoList = userMapper.getConsumerVoList(consumer);
        return ResultUtil.success(consumerVoList);
    }

    /***
     * 练习collection ,查询一个job类型有多少个顾客consumer
     * @author yangfeng
     * @date 2020/12/9
     * @param
     * @return clientconsumer.clientconsumer.util.Result
     *
     */
    @ResponseBody
    @PostMapping("/getJobVoList")
    public Result getJobVoList(@RequestBody Job job) {
        List<JobVo> jobVoList = userMapper.getJobVoList(job);
        return ResultUtil.success(jobVoList);
    }


    /***
     * 查询顾客信息
     * @author yangfeng
     * @date 2020/11/10
     * @param
     * @return java.lang.String
     *
     */
    @PostMapping("/getUserList")
    @ResponseBody
    public Result getUserList(@RequestBody Consumer consumer) {
        List<UserVo> userList = consumerService.getUserList(consumer);
        return ResultUtil.success(userList);
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Consumer consumer) {
        log.info("参数为=====" + consumer);
        try {
            Consumer consumer1 = consumerService.save(consumer);
            return ResultUtil.success(consumer1);
        } catch (Exception e) {
            log.error("保存consumer表数据报错！");
            return ResultUtil.fail(Code.FAIL_DATABASE, e.getMessage());
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody Consumer consumer) {
        log.info("参数为=====" + consumer);
        try {
            consumerService.delete(consumer);
            return ResultUtil.success();
        } catch (Exception e) {
            log.error("删除consumer表数据报错！");
            return ResultUtil.fail(Code.FAIL_DATABASE, e.getMessage());
        }
    }


}
