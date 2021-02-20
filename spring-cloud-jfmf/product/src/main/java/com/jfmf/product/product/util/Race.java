package com.jfmf.product.product.util;

/**
 * @author zhbr
 * @title: Race
 * @projectName spring-cloud-jfmf
 * @description: 有赛道距离；判断比赛是否结束；打印出胜利者；比赛开始；模拟兔子睡觉；乌龟胜利
 * @date 2020/12/1415:53
 */
public class Race implements Runnable{
    private static String winner ;

    @Override
    public void run() {
        for (int i = 0; i <= 1000;i++ ) {
            boolean end = isEnd(i);
            if (!end){
                if (Thread.currentThread().getName().equals("兔子") && i%10==0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"已经跑了"+(i)+"步");
            }
        }
    }
    public boolean isEnd(int step){
        if (winner!=null){
            return true;
        }{
            if (step>=100){
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }


}
