package clientconsumer.clientconsumer.lttest;

import java.util.stream.Stream;

/**
 * @author zhbr
 * @title: StreamTest
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/1/129:47
 */
public class StreamTest {

    public static void main(String[] args) {
        Stream.iterate(0, (a) -> a + 2).limit(8).forEach(System.out::println);
    }

}
