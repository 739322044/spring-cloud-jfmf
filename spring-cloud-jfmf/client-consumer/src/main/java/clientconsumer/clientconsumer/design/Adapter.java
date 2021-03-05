package clientconsumer.clientconsumer.design;

import javax.persistence.Table;

/**
 * @author zhbr
 * @title: Adapter
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/410:33
 */
public class Adapter {

}
interface Target{
    void request();
}

class Adaptee {
    public void execute(){
        System.out.println("adaptee 是实际需要进行适配的方法");
    }
}

class ObjectAdapter implements Target{

    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.execute();
    }
}




