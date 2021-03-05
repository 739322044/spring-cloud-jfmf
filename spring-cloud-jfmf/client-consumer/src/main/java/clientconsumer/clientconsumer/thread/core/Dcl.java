package clientconsumer.clientconsumer.thread.core;

/**
 * @author zhbr
 * @title: Dcl
 * @projectName spring-cloud-jfmf
 * @description: 单例--双重检查锁
 * @date 2021/2/2511:41
 */
public class Dcl {
    private volatile Dcl dcl;
    private Dcl(){}

    public Dcl getInstance(){

        if(dcl==null){
            synchronized (Dcl.class){
                if(dcl==null){
                    dcl = new Dcl();
                }
            }
        }
        return dcl;
    }
}
