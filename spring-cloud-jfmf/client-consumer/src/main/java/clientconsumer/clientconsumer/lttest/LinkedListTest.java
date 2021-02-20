package clientconsumer.clientconsumer.lttest;

/**
 * @author zhbr
 * @title: LinkedListTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/2111:28
 */
public class LinkedListTest {

    int size = 0;

    Node first;

    Node last;

    public void addFirst(Node e){
        //保存现在的首节点
        Node node = first;
        //创建新的节点， next指向下一个节点
        Node newNode = new Node(null,e,node);
        //创建的新节点做为首节点
        first = newNode;
        //如果原来的首节点是null
        if (node==null){
            last = newNode;
        }else {
            node.prev = newNode;
        }
        size++;
    }

    public void addLast(Node e){
        Node node = last;
        Node newNode = new Node(node,e,null);
        last = newNode;
        if (node==null){
            first = newNode;
        }else {
            node.next = newNode;
        }
        size++;
    }

    private static class Node {
        Node element;
        Node next;
        Node prev;

        public Node(Node prev,Node element, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
