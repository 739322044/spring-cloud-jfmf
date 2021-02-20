package clientconsumer.clientconsumer.thread.core;

/**
 * @author zhbr
 * @title: T3
 * @projectName spring-cloud-jfmf
 * @description: 为什么 synchronized可重入， 不可则父子类之间的方法存在问题
 * @date 2021/2/209:17
 */
public class T3 {

    public synchronized void m(){
        System.out.println("T3.........execute");
    }

    public static void main(String[] args) {
        //Tc3 tc3 = new Tc3();
        //tc3.m();
        T3 t3 = new Tc3();
        t3.m();
    }

}

class Tc3 extends T3 {
    @Override
    public synchronized void m() {
        System.out.println("Tc3.........execute");
        //

        super.m();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T3.........execute end");
    }
}
