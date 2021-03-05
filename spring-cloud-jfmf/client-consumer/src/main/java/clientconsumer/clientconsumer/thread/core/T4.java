package clientconsumer.clientconsumer.thread.core;

/**
 * @author zhbr
 * @title: T4
 * @projectName spring-cloud-jfmf
 * @description: volatile
 * @date 2021/2/2015:56
 */
public class T4 {
    volatile boolean running = true;

    void m(){
        System.out.println("start m");
        while (running){
            //System.out.println("execute");
        }
        System.out.println("end m");
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        new Thread(t4::m,"t4").start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.running = false;


    }

}
