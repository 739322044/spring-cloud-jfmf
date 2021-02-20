package clientconsumer.clientconsumer.consumer.vo;

import clientconsumer.clientconsumer.consumer.domain.Job;
import lombok.Data;

/**
 * @author zhbr
 * @title: UserVo
 * @projectName spring-cloud-jfmf
 * @description: 一个consumer包含一个job对象
 * @date 2020/11/615:45
 */
@Data
public class ConsumerVo {
    private String id;
    private String name;
    private double tall;
    private String level;
    private String jobId;

    //测试多参数子查询
    private String ssss;

    private Job job;

}
