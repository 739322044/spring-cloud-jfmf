package clientconsumer.clientconsumer.consumer.mapper;

import clientconsumer.clientconsumer.consumer.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author zhbr
 * @title: JobRepository
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/1011:47
 */
@Repository
public interface JobRepository extends JpaRepository<Job,String> {

    List<Job> findByJobNameAndDescribeAndSalary(String jobName, String describe, BigDecimal salary);

    List<Job> findByJobName(String jobName);

    /***
    	 * 1.更新info表下指定id的status字段， 这里使用了原生的sql语句。
     * 2.@Transactional 注解用于提交事务，若没有带上这句，会报事务异常提示。
     * 3.@Modifying(clearAutomatically = true) 自动清除实体里保存的数据。
    	 * @author yangfeng
    	 * @date 2020/11/10
    	 * @param
    	 * @return void
    	 *
    	 */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update job set job_name= ?1 where job_id=?2" ,nativeQuery = true)
    void updateById(String jobName,String jobId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update job set job_name= ?1 where job_id=?2" ,nativeQuery = true)
    void updateNameJob(String jobName,String jobId);
}
