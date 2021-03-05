package clientconsumer.clientconsumer.design;

/**
 * @author zhbr
 * @title: SingletonHunger
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/49:36
 */
public class SingletonHunger {


    private SingletonHunger(){}

     private static class Sing {
        private static SingletonHunger singletonHunger = new SingletonHunger();
    }
    public static SingletonHunger getInstance(){
        return Sing.singletonHunger;
    }

    public static void main(String[] args) {
       /* SingletonHunger singletonHunger1 = new SingletonHunger();
        SingletonHunger singletonHunger2 = new SingletonHunger();
        System.out.println(singletonHunger1==singletonHunger2);
        System.out.println(singletonHunger1.equals(singletonHunger2));*/
        System.out.println(Sing.singletonHunger==SingletonHunger.getInstance());
        System.out.println(SingletonHunger.getInstance()==SingletonHunger.getInstance());
        System.out.println(SingletonHunger.getInstance().equals(SingletonHunger.getInstance()));
    }

}
