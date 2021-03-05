package clientconsumer.clientconsumer.thread.core;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhbr
 * @title: ThreadPoolTest
 * @projectName spring-cloud-jfmf
 * @description: 线程池练习
 * @date 2021/2/2515:58
 */
public class ThreadPoolTest implements Runnable{


    private static int corePoolSize = 10;
    private static int max = 20;
    private static long time = 50;
    private static int queue_capatil = 100;


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,max,time,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queue_capatil),new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 20; i++) {
            ThreadPoolTest threadPoolTest = new ThreadPoolTest();
            threadPoolExecutor.execute(threadPoolTest);
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){
        }
        System.out.println("threadPoolExecutor execute over");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"  start "+new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"  end "+new Date());
    }


}
