package clientconsumer.clientconsumer.consumer.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhbr
 * @title: Consumer
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/11/614:27
 */
@Entity
@Table(name = "consumer")
@Data
public class Consumer implements Serializable {

    private static final long serialVersionUID = -7924993963841923180L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME",nullable = false)
    private String name;
    @Column(name = "TALL")
    private double tall;
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "LEVEL")
    private String level;


}
