package clientconsumer.clientconsumer.consumer.vo;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhbr
 * @title: JobVo
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/915:07
 */
@Data
public class JobVo {

    private String jobId;
    private String jobName;
    private String describe;
    private BigDecimal salary;
    private List<Consumer> consumerList;

}
