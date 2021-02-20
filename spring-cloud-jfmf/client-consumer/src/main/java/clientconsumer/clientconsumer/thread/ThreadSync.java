package clientconsumer.clientconsumer.thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zhbr
 * @title: 线程同步：多个线程操作同一个资源
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/1811:34
 */
public class ThreadSync {

    public static void main(String[] args) {
        /*SingleLight singleLight = new SingleLight();
        new Thread(singleLight,"信号灯").start();*/
        List<String> list = new ArrayList<>();
        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
        for (int i = 0; i < 100000; i++) {
            new Thread(()->list.add(Thread.currentThread().getName())).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());

    }

}

class SingleLight implements Runnable{

    //true 绿灯行， false 红灯停
    private boolean isWalk ;

    private int green = 30;
    private int red = 40;

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            changeSingle();
            if (isWalk){
                Thread.sleep(1000);
                System.out.println("绿灯"+green--);
            }else {
                Thread.sleep(1000);
                System.out.println("红灯"+red--);
            }
        }
    }

    public void changeSingle(){
        if (green==0){
            //绿灯时间到了，切换为红灯，并把绿灯时间重置
            isWalk = false;
            green = 30;
        }else if(red==0){
            isWalk = true;
            red = 40;
        }
    }

}



