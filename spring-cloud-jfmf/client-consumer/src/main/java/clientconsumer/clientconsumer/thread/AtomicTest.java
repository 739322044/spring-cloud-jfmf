package clientconsumer.clientconsumer.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhbr
 * @title: AtomicTest
 * @projectName spring-cloud-jfmf
 * @description: 原子操作类
 * @date 2021/2/2611:42
 */
public class AtomicTest {
    private AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {


    }
    // getInt 不加synchronized也会是线程安全的
    public Integer getInt(){
        return atomicInteger.incrementAndGet();
    }


}
