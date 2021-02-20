package clientconsumer.clientconsumer.consumer.mapper;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import clientconsumer.clientconsumer.consumer.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhbr
 * @title: DatabaseTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/611:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void jpaTest(){
//        List<Consumer> all = userRepository.findAll();
        List<Consumer> all = consumerRepository.findByNameAndLevel("shenjian",6);
        all.stream().forEach(System.out::println);
    }

    @Test
    public void mybatisTest(){
        Consumer consumer = new Consumer();
        consumer.setName("n");

        List<UserVo> userList = userMapper.getUserList(consumer);
        userList.stream().forEach(System.out::println);
    }


}
