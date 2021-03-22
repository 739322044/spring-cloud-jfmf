package clientconsumer.clientconsumer.leetcode;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author zhbr
 * @title: Test2
 * @projectName spring-cloud-jfmf
 * @description: 无重复字符的最长子串
 * @date 2021/3/911:18
 */
public class Test2 {
    public static void main(String[] args) {
        hash();
        try {
            copyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "abcabelkjcbb";
        System.out.println(getMax(str));
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","ha");
        map.entrySet();
        map.keySet();
        map.forEach((key,value)->{
            String s1 = key;
            Object s2 = value;
        });
        map.keySet().stream().forEach(key-> System.out.println(map.get(key)));
    }

    public static int getMax(String num){
        char[] chars = num.toCharArray();
        int max = 0;
        //从第一个开始循环
        for (int i = 0; i <chars.length ;i++ ) {
            int sum = 0;
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (set.add(chars[j])){
                    sum++;
                }else {
                    if (max<sum)
                        max = sum;
                    break;
                }
            }
        }
        return max;
    }

    public static void copyFile () throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\rdcpm\\target.txt"));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\rdcpm\\copy.txt"));
        int n = -1;
        byte[] bytes = new byte[2048];
        while ((n =(in.read(bytes,0,bytes.length)))!=(-1)){
            out.write(bytes,0,n);
            System.out.println(bytes);
        }
        out.flush();
        out.close();
        in.close();
    }

    public static void hash (){
        User yangfeng1 = new User("yangfeng", 27);
        User yangfeng2= new User("yangfeng", 27);
        User yangfeng3= new User("yangfeng", 28);

        System.out.println("hashcode 是否相同===="+(yangfeng1.hashCode()==yangfeng2.hashCode()));
        System.out.println("hashcode 是否相同===="+(yangfeng1.hashCode()==yangfeng3.hashCode()));

        System.out.println("equals 是否相同==="+(yangfeng1.equals(yangfeng2)));
        System.out.println("equals 是否相同==="+(yangfeng1.equals(yangfeng3)));


    }

}

class User{
    String name;
    int old;

    public User(String name, int old) {
        this.name = name;
        this.old = old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return old == user.old &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, old);
    }
}
