package clientconsumer.clientconsumer.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhbr
 * @title: 死锁：相互持有对方需要的锁
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/1815:17
 */
public class DeathLock {
    public static void main(String[] args) {
        new Thread(new Marry("gary")).start();
        new Thread(new Marry("haha")).start();
    }

}
class Car {}

class House {}


class Marry implements Runnable{

    ReentrantLock lock = new ReentrantLock();


    static Car car = new Car();
    static House house = new House();

    String name = "";

    public Marry(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            marry();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void marry() throws InterruptedException {
        if ("gary".equals(name)){
            synchronized (car){
                System.out.println(name+"有了car的锁");
                Thread.sleep(1000);
                synchronized (house){
                    System.out.println(name+"有了house的锁");
                    synchronized (house){
                        System.out.println(name+"有了house的锁");
                    }
                }
            }
        }else {
            //另一个线程进来先获得house锁
            //synchronized (house){
                lock.lock();
                System.out.println(name+"获得了house锁");
                Thread.sleep(1000);
                synchronized (car){
                    System.out.println(name+"获得了car锁");
                }
                lock.unlock();

        }
    }

}



