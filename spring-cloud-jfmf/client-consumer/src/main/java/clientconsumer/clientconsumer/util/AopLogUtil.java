package clientconsumer.clientconsumer.util;

import lombok.extern.log4j.Log4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zhbr
 * @title: AopLogUtil
 * @projectName spring-cloud-jfmf
 * @description: 通过AOP为controller增加环绕增强，输出方法执行所用的时间
 * @date 2020/12/2210:10
 */
@Aspect
@Component
public class AopLogUtil {

    private final Logger logger = LoggerFactory.getLogger(AopLogUtil.class);

    //切入点 ：指定哪些方法执行时，需要执行增强方法
    @Pointcut("execution(private * clientconsumer.clientconsumer.consumer.controller..*.*(..))")
    public void controller(){}

    @Pointcut("execution(public * clientconsumer.clientconsumer.consumer.controller..*.*(..))")
    public void controller1(){}

    @Around("controller1()")
    public void printStartEndTime(ProceedingJoinPoint pjp){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("开始调用："+format.format(new Date()));
        long start = System.currentTimeMillis();
        try {
            Object proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("结束调用："+format.format(new Date()));
        double time = (end-start)/1000.0;
        logger.info("本次调用共用了"+time+"秒");
    }

    @AfterReturning(pointcut = "controller()" ,returning = "result")
    public void afterReturn(Result result){
        logger.info("执行@AfterReturning..." );
        logger.info(result.toString());
    }


    @After("controller()")
    public void printLog(JoinPoint joinPoint){
        joinPoint.getArgs();
        Arrays.asList(joinPoint.getArgs()).stream().forEach(System.out::println);
        joinPoint.getTarget();
        joinPoint.toString();
        //execution(Result clientconsumer.clientconsumer.consumer.controller.ConsumerController.transactionalTest(Consumer))

        joinPoint.getKind();
        joinPoint.getSignature();
        joinPoint.getSourceLocation();
        joinPoint.getStaticPart();
        joinPoint.getThis();
        joinPoint.toLongString();
        joinPoint.toShortString();
        logger.info("执行AopLogUtil.printLog");
    }

}
