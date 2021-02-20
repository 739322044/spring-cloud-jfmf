package clientconsumer.clientconsumer.lttest;

import sun.nio.ch.DirectBuffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author zhbr
 * @title: BaseJava
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/2110:17
 */
public class BaseJava {

    public static void main(String[] args) {
        while (true){
            test2();
        }

    }

    public static void test1(){
        Integer integer = Integer.valueOf(1);
        int i = integer.intValue();
        try {
            Class<?> aClass = Class.forName("clientconsumer.clientconsumer.lttest.BaseJava");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void test2(){
        Collection collection = new ArrayList();
        ArrayList<Object> objects = new ArrayList<>(500);

    }


}
