package clientconsumer.clientconsumer.thread.core;

/**
 * @author zhbr
 * @title: T2
 * @projectName spring-cloud-jfmf
 * @description: 模拟转账延迟
 * @date 2021/2/1917:15
 */
public class T2 {
    private int count ;
    private String name;

    public synchronized void set (int count,String name){
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.count = count;
    }
    public synchronized int get(){
        return this.count;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        new Thread(()->t2.set(100,"yangfeng")).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t2.get());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t2.get());

    }
}
