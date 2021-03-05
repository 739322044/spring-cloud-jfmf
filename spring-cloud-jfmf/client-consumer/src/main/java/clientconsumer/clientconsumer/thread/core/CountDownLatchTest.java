package clientconsumer.clientconsumer.thread.core;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhbr
 * @title: CountDownLatchTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/419:38
 */
public class CountDownLatchTest {
    int sum  =0;
    private Thread[] threads = new Thread[100];
    private CountDownLatch countDownLatch = new CountDownLatch(threads.length);

    public void execute(){

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000 ; j++) {
                    sum += j;
                }
            });
            countDownLatch.countDown();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        try {
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        countDownLatchTest.execute();
        System.out.println(countDownLatchTest.sum);
        //274826759


    }


}
