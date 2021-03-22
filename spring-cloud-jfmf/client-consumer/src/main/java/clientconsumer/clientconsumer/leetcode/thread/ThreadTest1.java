package clientconsumer.clientconsumer.leetcode.thread;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhbr
 * @title: ThreadTest1
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/514:43
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        System.out.println('A'+1);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("12");
        arrayList.add("344");
        arrayList.remove("12");

    }

    public void print(String str){
        Thread[] threads = new Thread[3];
        threads[0] = new Thread(()->Foo.first(),"A");


    }

}



class Foo{
    public static void first(){
        System.out.println("first");
    }
    public void second(){
        System.out.println("second");
    }
    public void third(){
        System.out.println("third");
    }
}




