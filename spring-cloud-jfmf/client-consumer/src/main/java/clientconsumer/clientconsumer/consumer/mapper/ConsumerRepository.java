package clientconsumer.clientconsumer.consumer.mapper;

import clientconsumer.clientconsumer.consumer.domain.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhbr
 * @title: UserRepository
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/614:39
 */
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Integer> {

    List<Consumer> findByNameAndLevel(String name, int level);

}
