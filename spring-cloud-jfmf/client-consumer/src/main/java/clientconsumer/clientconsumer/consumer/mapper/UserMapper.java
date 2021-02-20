package clientconsumer.clientconsumer.consumer.mapper;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import clientconsumer.clientconsumer.consumer.domain.Job;
import clientconsumer.clientconsumer.consumer.vo.ConsumerVo;
import clientconsumer.clientconsumer.consumer.vo.JobVo;
import clientconsumer.clientconsumer.consumer.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhbr
 * @title: UserMapper
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/615:56
 */
@Repository
@Mapper
public interface UserMapper {

    List<UserVo> getUserList(Consumer consumer);

    List<String> selectPubOrgan(@Param("deptName")String deptName);


    List<ConsumerVo> getConsumerVoList2(Consumer consumer);
    List<ConsumerVo> getConsumerVoList(Consumer consumer);

    List<JobVo> getJobVoList(Job job);

    void updateAme(Consumer consumer);
    void updateConsumer(Consumer consumer);
    void updateJobDes(Consumer consumer);

    List<Consumer> selectList ( List<Map<String,Object>> mapList,List<Map<String,Object>> mapList2);
    List<Consumer> selectList ( List<Map<String,Object>> mapList );
    List<Consumer> selectList (@Param("map1") Map<String,Object> map );

    void updateJobName(@Param("jobName") String jobName,@Param("jobId") String jobId);
    void updateJobNameDescribe(@Param("jobName") String jobName,@Param("jobId") String jobId,@Param("describe") String describe);
    List<Job> findByJobName (@Param("jobName")String jobName);

}
