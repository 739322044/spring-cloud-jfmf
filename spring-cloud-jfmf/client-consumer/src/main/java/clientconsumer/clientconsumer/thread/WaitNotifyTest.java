package clientconsumer.clientconsumer.thread;

/**
 * @author zhbr
 * @title: WaitNotifyTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/129:48
 */
public class WaitNotifyTest {

    static Object synObj = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (synObj){
                System.out.println("start .... aaaaa");
                try {
                    synObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end .... aaaaa");
            }
        },"wait").start();
        new Thread(()->{
            synchronized (synObj){
                System.out.println("start .... bbbbb");
                try {
                    Thread.sleep(3000);
                    synObj.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end ..... bbbb");

            }

        },"notify").start();

    }
    // O(n^2)
    void aFunc(int n) {
        for (int i = 0; i < n; i++) { //n
            for (int j = i; j < n; j++) {  //  n-i
                System.out.println("Hello World\n"); // 1
            }
        }
    }

    //
    void aFunc1(int n) {
        for (int i = 2; i < n; i++) {
            i *= 2;
            System.out.println(i);
        }
        // t 是循环次数
        // t=1 ， i = 4
        // t=2 ,  i = 8
        // t=3 ,  i = 16
        // ...    i = 2^(t+1)
        // 循环的条件是 2^(t+1) < n
        // t+1 = log(2)(n) -->  复杂度 O(lg n)
    }

    long aFunc2(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return aFunc2(n - 1) + aFunc2(n - 2);
        }
    }
    //   n=10 ---->   (n-1)+(n-2) +(n-2)+(n-3) + (n-3)+(n-4)
    //
    //   n=10 ---->
    //   n=10 ---->
    //   n=10 ---->
    //   n=10 ---->
    //   n=10 ---->

    public static void test4(){
        int n = 123456;
        char[] chars = (n+"").toCharArray();

    }

}



