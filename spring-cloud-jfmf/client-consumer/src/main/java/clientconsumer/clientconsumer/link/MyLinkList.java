package clientconsumer.clientconsumer.link;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author zhbr
 * @title: MyLinkList
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/410:48
 */
public class MyLinkList {

    private int size ;
    private Node first;
    private Node last;

    class Node{
        private Object value;
        private Node next;

        Node(Object value){
            this.value = value;
        }

    }
    public void add(Object obj){
        Node node = new Node(obj);
        if (first==null){
            first = node;
            last = node;
        }else {
            Node temp = last;
            temp.next = node;
            last = node;
        }
        size++;
    }

    public static void main(String[] args) {
        //LinkedList
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());


        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1);
        int i = calendar.get(Calendar.DAY_OF_WEEK);


        System.out.println(calendar.getTime());
        System.out.println(i);
    }

}
