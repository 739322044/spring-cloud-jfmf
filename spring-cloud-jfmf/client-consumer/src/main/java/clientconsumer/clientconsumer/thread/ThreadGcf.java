package clientconsumer.clientconsumer.thread;

/**
 * @author zhbr
 * @title: 利用缓冲区解决消费者生产者的问题--管程法
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/1815:45
 */
public class ThreadGcf {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Thread(new Productor(synContainer)).start();
        new Thread(new Consumer(synContainer)).start();
    }
}

class Productor implements  Runnable{
    private SynContainer synContainer ;

    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了chicken"+i);
            synContainer.push(new Chicken(i));
        }

    }
}

class Consumer implements Runnable{

    private SynContainer synContainer ;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了chicken"+i);
            synContainer.pop();
        }
    }
}
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {

    private Chicken[] chickens = new Chicken[10];
    //计数器
    int count = 0;
    public synchronized void push(Chicken chicken){
        //如果缓冲已经满了，通知生产者进行等待
        if (chickens.length==count){

            try {
                Thread.sleep(1000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满
        chickens[count] = chicken;
        count++;

        //在通知消费者进行消费
        this.notifyAll();
    }
    public synchronized Chicken pop(){
        //如果缓冲池空了，通知消费者等待
        if (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //缓冲中有，则进行消费
        count--;
        Chicken chicken = chickens[count];


        //通知生产者生产
        this.notifyAll();

        return chicken;
    }


}









