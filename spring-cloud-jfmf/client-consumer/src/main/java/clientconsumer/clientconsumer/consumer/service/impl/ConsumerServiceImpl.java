package clientconsumer.clientconsumer.consumer.service.impl;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import clientconsumer.clientconsumer.consumer.mapper.UserMapper;
import clientconsumer.clientconsumer.consumer.mapper.ConsumerRepository;
import clientconsumer.clientconsumer.consumer.service.ConsumerService;
import clientconsumer.clientconsumer.consumer.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhbr
 * @title: ConsumerServiceImpl
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/617:00
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ConsumerRepository consumerRepository;


    @Override
    public void transactionalTest(Consumer consumer) {





    }


    public List<UserVo> getUserList(Consumer consumer){
        List<UserVo> userList = userMapper.getUserList(consumer);
        return userList;
    }

    @Override
    public Consumer save(Consumer consumer) {
        return consumerRepository.save(consumer);
    }

    @Override
    public void delete(Consumer consumer) {
        consumerRepository.delete(consumer);
    }

}
