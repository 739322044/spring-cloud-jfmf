package clientconsumer.clientconsumer.consumer.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author zhbr
 * @title: Job
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/615:17
 */
@Entity
@Table(name = "job")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private String jobId;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "describe")
    private String describe;
    @Column(name = "salary")
    private BigDecimal salary;

}
