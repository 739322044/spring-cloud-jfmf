package clientconsumer.clientconsumer.consumer.vo;

import clientconsumer.clientconsumer.consumer.domain.Job;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author zhbr
 * @title: UserVo
 * @projectName spring-cloud-jfmf
 * @description: 一个consumer包含一个job对象
 * @date 2020/11/615:45
 */
@Data
public class UserVo {
    private String jobId;
    private String name;
    private double tall;
    private String level;
    private Job job;

}
