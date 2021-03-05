package clientconsumer.clientconsumer.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static com.alibaba.fastjson.parser.Feature.AllowComment;

/**
 * @author zhbr
 * @title: JSONObjectUtil
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/2/210:15
 */
public class JSONObjectUtil {

    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","yf");

        jsonObject.put("bytes","ssssaaaabbbbcccsssdddd");
        byte[] bytes = jsonObject.getBytes("bytes");




    }

    public static void test2(){
        String str = "{\n" +
                "    \"loginDeptCode\": \"40101005110000001\",\n" +
                "    \"versionNo\": \"-5\",\n" +
                "    \"appId\": \"01\",\n" +
                "    \"planYear\": \"2021\",\n" +
                "    \"deptTypeId\": \"0102\",\n" +
                "    \"deptCode\": \"41201025810000001\",\n" +
                "    \"itemName\": \"\",\n" +
                "    \"deptLevel\": \"1\",\n" +
                "    \"pageLabel\": \"计划决策\",\n" +
                "    \"speciality\": \"01\",\n" +
                "    \"current\": \"1\",\n" +
                "    \"size\": \"10\",\n" +
                "    \"magType\": \"\"\n" +
                "}";
        Object planYear = JSON.parseObject(str).get("planYear");

        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONArray jsonArray = JSONArray.parseArray(str);

        Object parse = JSON.parse(str);

        Param param = JSONObject.parseObject(str, Param.class);
        JSONObject jsonObject1 = JSONObject.parseObject(str, AllowComment);

    }
}
class Param {
    String loginDeptCode ;
    String size ;

    public String getLoginDeptCode() {
        return loginDeptCode;
    }

    public void setLoginDeptCode(String loginDeptCode) {
        this.loginDeptCode = loginDeptCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
