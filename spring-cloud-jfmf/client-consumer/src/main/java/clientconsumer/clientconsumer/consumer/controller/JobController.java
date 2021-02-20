package clientconsumer.clientconsumer.consumer.controller;

import clientconsumer.clientconsumer.consumer.domain.Job;
import clientconsumer.clientconsumer.consumer.mapper.JobRepository;
import clientconsumer.clientconsumer.consumer.mapper.UserMapper;
import clientconsumer.clientconsumer.consumer.service.JobService;
import clientconsumer.clientconsumer.util.Code;
import clientconsumer.clientconsumer.util.Result;
import clientconsumer.clientconsumer.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhbr
 * @title: JobController
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/1011:44
 */
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {

    @Autowired
    private JobService jobService;
    @Autowired
    private UserMapper userMapper;

    private static AtomicInteger size = new AtomicInteger(-1);

    @PostMapping("/updateBaseItem")
    @ResponseBody
    @Transactional(isolation=Isolation.READ_UNCOMMITTED)
    public Result updateBaseItem(@RequestBody Job job){


        List<Job> jobList = userMapper.findByJobName(job.getJobName());
        long start = System.currentTimeMillis();
        log.info("start ==="+new Date(start));
        //单线程处理  cost 62.379 second  /  cost 7.557 second
        //singleThread(jobList,userMapper);

        //多线程  cost 63.094 second
        try {
            testThread(jobList,userMapper);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        double time = (end-start)/1000.0;
        log.info("cost "+time+" second");


        return ResultUtil.success();
    }

    public static void singleThread(List<Job> jobList,UserMapper userMapper){
        if (jobList!=null){
            for (Job jobTemp :jobList){
                jobTemp.setJobName("经理Thread");
                // 只有jobId主键索引查询时，是行锁， 该表的其他数据还是可以查询
                //
                userMapper.updateJobName(jobTemp.getJobName(),jobTemp.getJobId());
                //userMapper.updateJobNameDescribe(jobTemp.getJobName(),jobTemp.getJobId(),jobTemp.getDescribe());
            }
        }
    }

    public void testThread(List<Job> jobList, UserMapper userMapper) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            synchronized (jobService) {
                Thread thread = new Thread(() -> {
                    while (size.addAndGet(1) < jobList.size() - 1) {

                        Job job = jobList.get(size.get());
                        job.setJobName("经理Thread");
                        userMapper.updateJobName(job.getJobName(), job.getJobId());
                    }

                }, "Thread" + i);
                thread.start();

            }
        }

        System.out.println("处理数据==="+size.get()+"条");


    }













    @PostMapping("/findJobList")
    @ResponseBody
    public Result findJobList(@RequestBody Job job){
        log.info("参数为====="+job);
        try {
            List<Job> jobList = jobService.findJobList(job);
            return ResultUtil.success(jobList);
        }catch (Exception e){
            return ResultUtil.fail(Code.FAIL_DATABASE,e.getMessage());
        }
    }
    @PostMapping("/findJobListByJobName")
    @ResponseBody
    public Result findJobListByJobName(@RequestBody Job job){
        log.info("参数为====="+job);
        try {
            List<Job> jobList = jobService.findJobListByJobName(job);
            return ResultUtil.success(jobList);
        }catch (Exception e){
            return ResultUtil.fail(Code.FAIL_DATABASE,e.getMessage());
        }
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(@RequestBody Job job){
        log.info("参数为====="+job);
        try {
            Job job1 = jobService.save(job);
            return ResultUtil.success(job1);
        }catch (Exception e){
            log.error("保存职业表数据报错！");
            return ResultUtil.fail(Code.FAIL_DATABASE,e.getMessage());
        }
    }
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody Job job){
        log.info("参数为====="+job);
        try {
            jobService.delete(job);
            return ResultUtil.success();
        }catch (Exception e){
            log.error("删除职业表数据报错！");
            return ResultUtil.fail(Code.FAIL_DATABASE,e.getMessage());
        }
    }
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody Job job){
        log.info("参数为====="+job);
        try {
            jobService.update(job);
            return ResultUtil.success();
        }catch (Exception e){
            log.error("更新职业表数据报错！");
            return ResultUtil.fail(Code.FAIL_DATABASE,e.getMessage());
        }
    }









}
