package clientconsumer.clientconsumer.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author zhbr
 * @title: Test
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/2/2417:05
 */
public class Test {

    public static void main(String[] args) {
        int i = 1;
        System.out.println("<< 1位："+(i<<1));
        System.out.println("<< 2位："+(i<<2));
        System.out.println("<< 3位："+(i<<3));

        int a = 16;
        System.out.println(">> 1位："+(a>>1));
        System.out.println(">> 2位："+(a>>2));


        System.out.println("10 ~ = "+(~10));

    }

    public void test1() {

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

    }

}
