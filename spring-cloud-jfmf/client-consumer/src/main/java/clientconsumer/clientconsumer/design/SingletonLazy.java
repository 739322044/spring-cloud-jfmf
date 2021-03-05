package clientconsumer.clientconsumer.design;

/**
 * @author zhbr
 * @title: SingletonLazy
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/49:35
 */
public class SingletonLazy {

   private SingletonLazy singletonLazy;
   private SingletonLazy(){}

   public SingletonLazy getInstance(){
       if (singletonLazy==null){
           synchronized (SingletonLazy.class){
               if(singletonLazy==null){
                   singletonLazy = new SingletonLazy();
               }
           }
       }
       return singletonLazy;
   }

    public static void main(String[] args) {
        SingletonLazy singletonLazy = new SingletonLazy();
        System.out.println(singletonLazy.getInstance().equals(singletonLazy.getInstance()));
    }

}
