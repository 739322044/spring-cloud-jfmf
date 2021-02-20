package com.jfmf.product.product.util;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * @author zhbr
 * @title: ThreadRace
 * @projectName spring-cloud-jfmf
 * @description: 描述龟兔赛跑
 * 有赛道距离；判断比赛是否结束；打印出胜利者；比赛开始；模拟兔子睡觉；乌龟胜利
 * @date 2020/12/1415:15
 */
public class ThreadRace implements Runnable {
    //
    private volatile int sum = 0;
    private static Object obj = new Object();
    private  Object obj1 = new Object();

    public static void main(String[] args) {
        ThreadRace race = new ThreadRace();
        race.test();
    }

    public void test(){
        ThreadRace race = new ThreadRace();
        synchronized(obj1){
            new Thread(race,"miracle").start();
            new Thread(race,"go").start();
            new Thread(race,"ame").start();
        }
    }


    @Override
    public void run() {
        while (true){
            if (sum>100){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"走了"+sum+++"步");
        }
    }
}


