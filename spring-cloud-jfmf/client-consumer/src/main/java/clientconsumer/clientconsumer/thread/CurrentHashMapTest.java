package clientconsumer.clientconsumer.thread;

import io.netty.util.concurrent.SingleThreadEventExecutor;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhbr
 * @title: CurrentHashMapTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/415:26
 */
public class CurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        map.put("name","yangfeng");

        //SingleThreadEventExecutor
        ExecutorService executorService = Executors.newCachedThreadPool();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        CountDownLatch countDownLatch = new CountDownLatch(10);

    }
}
