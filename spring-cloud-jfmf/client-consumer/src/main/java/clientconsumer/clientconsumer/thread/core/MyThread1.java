package clientconsumer.clientconsumer.thread.core;

/**
 * @author zhbr
 * @title: MyThread1
 * @projectName spring-cloud-jfmf
 * @description: 简单实用synchronized
 * @date 2021/2/1915:30
 */
public class MyThread1   {
    private Object object = new Object();
    private int count = 100;

    public void sub(){
        synchronized (object){

                count--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"execute ,count="+count);


        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread thread = new Thread(() -> myThread1.sub());
        Thread thread1 = new Thread(() -> myThread1.sub());
        for (int i = 0; i < myThread1.count/2; i++) {
            thread.start();
            thread1.start();
        }

    }


}
