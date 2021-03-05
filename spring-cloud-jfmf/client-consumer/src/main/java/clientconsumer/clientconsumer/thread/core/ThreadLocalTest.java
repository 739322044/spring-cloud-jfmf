package clientconsumer.clientconsumer.thread.core;

import java.text.SimpleDateFormat;

/**
 * @author zhbr
 * @title: ThreadLocalTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/2/2515:34
 */
public class ThreadLocalTest implements Runnable {
    private ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        for (int i = 0; i < 5; i++) {
            new Thread(threadLocalTest,"Thread"+i).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"SimpleDateFormat=="+threadLocal.get().toPattern());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadLocal.set(new SimpleDateFormat("yy-mm-dd"));
        System.out.println(Thread.currentThread().getName()+"new SimpleDateFormat=="+threadLocal.get().toPattern());
    }
}
