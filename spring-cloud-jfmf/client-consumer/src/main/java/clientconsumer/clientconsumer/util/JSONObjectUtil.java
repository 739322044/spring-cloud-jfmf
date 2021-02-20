package clientconsumer.clientconsumer.util;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * @author zhbr
 * @title: JSONObjectUtil
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/2/210:15
 */
public class JSONObjectUtil {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","yf");

        jsonObject.put("bytes","ssssaaaabbbbcccsssdddd");
        byte[] bytes = jsonObject.getBytes("bytes");

    }
}
