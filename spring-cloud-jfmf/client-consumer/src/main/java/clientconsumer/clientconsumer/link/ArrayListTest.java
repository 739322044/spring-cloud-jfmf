package clientconsumer.clientconsumer.link;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @author zhbr
 * @title: ArrayListTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/614:31
 */
public class ArrayListTest {
    public static void main(String[] args) {

//        int a = 10;
//        int b = a>>1;
//        int c = a>>2;
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("12");
//        arrayList.add("344");
//        arrayList.remove("12");
       //test1();
        create2();
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<>();
        map.put("name","yf");
        map.put("age","27");
    }
    public static void test1(){
        int a =16;
        System.out.println("16的二进制表示==="+(Integer.toBinaryString(a)));
        System.out.println("16的二进制  >> 1表示==="+(Integer.toBinaryString(a>>1)));
        System.out.println("16的二进制  << 1表示==="+(Integer.toBinaryString(a<<1)));
        int a1 = a>>>2;
        System.out.println("a>>>16"+a1);

        int a2 = a ^ a>>>16;
        System.out.println(" a ^ a>>>16"+a2);

        int a3 = (a ^ a>>>16) & 0x7fffffff;
        System.out.println("a ^ a>>>16) & 0x7fffffff"+a3);

    }

    public static void create2(){
        Integer[] integers = new Integer[10];
        integers[0] = 0;
        integers[1] = 0;
        integers[2] = 0;
        Stream<Integer> stream = Arrays.stream(integers);
        int a = 100;
        stream.map( b -> new Random().nextInt(a)).forEach(System.out::println);
    }

    public static void create3() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        condition1.await();
        System.out.println("加锁...");
        condition1.signal();
        ThreadLocal<String> sdfafafafafafa = ThreadLocal.withInitial(() -> new String("sdfafafafafafa"));
    }

}
