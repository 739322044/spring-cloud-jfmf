package clientconsumer.clientconsumer.consumer.service;

import clientconsumer.clientconsumer.consumer.domain.Job;

import java.util.List;

/**
 * @author zhbr
 * @title: JobService
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/1011:44
 */
public interface JobService {
    List<Job> findJobList(Job job);
    List<Job> findJobListByJobName(Job job);

    Job save(Job job);
    void delete(Job job);
    void update(Job job);
}
