package clientconsumer.clientconsumer.design;

/**
 * @author zhbr
 * @title: Proxy
 * @projectName spring-cloud-jfmf
 * @description: 代理模式，静态
 * @date 2021/3/410:21
 */
public class Proxy {



}

interface Subject{
    void request();
}
class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("execute RealSubject.request");
    }
}
class ProxySubject {
    private RealSubject realSubject = new RealSubject();
    public void request(){
        System.out.println("pre ...");
        realSubject.request();
        System.out.println("after ...");
    }
}






