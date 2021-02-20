package clientconsumer.clientconsumer.consumer.service.impl;

import clientconsumer.clientconsumer.consumer.domain.Job;
import clientconsumer.clientconsumer.consumer.mapper.JobRepository;
import clientconsumer.clientconsumer.consumer.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhbr
 * @title: JobServiceImpl
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/1011:45
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findJobList(Job job) {
        return jobRepository.findByJobNameAndDescribeAndSalary(job.getJobName(),job.getDescribe(),job.getSalary());
    }
    @Override
    public List<Job> findJobListByJobName(Job job) {
        return jobRepository.findByJobName(job.getJobName());
    }

    @Override
    public Job save(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void delete(Job job) {
        jobRepository.delete(job);
    }
    @Override
    public void update(Job job) {
        jobRepository.updateById(job.getJobName(),job.getJobId());
    }
}
