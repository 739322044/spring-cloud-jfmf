package clientconsumer.clientconsumer.thread.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhbr
 * @title: ReadWriteLockTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/420:18
 */
public class ReadWriteLockTest {
    //可重入，排他锁
    private final static ReentrantLock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock redaLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
    }
}
