package clientconsumer.clientconsumer.lttest;

/**
 * @author zhbr
 * @title: Test1
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/2810:37
 */
public class Test1 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int a = (int)time/10;
        int b = (int) ((int)time/10.0);

        float c = time/10;
        float d = (float) (time/10.0);

        double e = time/10;
        double f = time/10.0;
        System.out.println();

    }

}
