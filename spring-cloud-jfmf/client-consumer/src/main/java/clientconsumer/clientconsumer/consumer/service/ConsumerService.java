package clientconsumer.clientconsumer.consumer.service;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import clientconsumer.clientconsumer.consumer.domain.Job;
import clientconsumer.clientconsumer.consumer.vo.UserVo;

import java.util.List;

/**
 * @author zhbr
 * @title: ConsumerService
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/617:00
 */
public interface ConsumerService {

    void transactionalTest(Consumer consumer);

    List<UserVo> getUserList(Consumer consumer);

    Consumer save(Consumer consumer);
    void delete(Consumer consumer);
}
