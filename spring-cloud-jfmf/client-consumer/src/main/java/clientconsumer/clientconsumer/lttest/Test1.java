package clientconsumer.clientconsumer.lttest;

import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhbr
 * @title: Test1
 * @projectName spring-cloud-jfmf
 * @description: 练习lambda四种函数接口
 * @date 2020/12/2810:37
 */
public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.testCons();
        System.out.println(test1.testGetint());
        System.out.println(test1.testPre());
        test1.testStream();


    }

    public List<String> function(String str, Function<String, List<String>> function){
        return function.apply(str);
    }
    public List<String> testFunc(String string){
        string = "1,2,3,4,5";
        return function(string,str->Arrays.asList(str.split(",")));
    }

    public void consumer (String string, Consumer<String> consumer){
        consumer.accept(string);
    }
    public void testCons(){
        String str = "hello,dota,world,w33";
        consumer(str,string->Arrays.asList(string.split(",")).stream().forEach(System.out::println));
    }
    public Integer getInteger (Supplier<Integer> supplier){
        return  supplier.get();
    }

    public Integer testGetint(){
        return getInteger(()->new Random().nextInt(1000));
    }

    public boolean predicate(String str, Predicate<String> predicate){
        return predicate.test(str);
    }

    public boolean testPre(){
        String str = "hello world";
        return predicate(str,string->"hello world333333333".contains(str));
    }
    //stream

    public void testStream(){
        Stream<Integer> is = Stream.of(1, 2, 3, 3, 4, 5,21,3123,123,32,12,32, 66);
        Stream<Integer> is1 = Stream.of(1, 2, 3, 3, 4, 5,21,3123,123,32,12,32, 66);
        Integer integer = is.reduce((e1, e2) -> e1 + e2).get();
        System.out.println(integer);
        Integer integer1 = is1.reduce(10000000,(e1, e2) -> e1 + e2);
        System.out.println(integer1);
    }
    //optional
    public void optional(){
        Object o = new Object();
        Optional<Object> o1 = Optional.of(o);
        Optional<Object> o2 = Optional.ofNullable(o);
        o1.ifPresent(obj->obj.toString());


    }




}
