package clientconsumer.clientconsumer.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author zhbr
 * @title: HttpClientUtil
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/917:27
 */
@Slf4j
@Component
public class HttpClientUtil {
    @Autowired
    private RestTemplate restTemplate;

    public Result doPost(String url, Map param,String token){
        log.info("调用接口时的参数===="+param+" \n url=="+url);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type","application/json");
        if (!StringUtils.isEmpty(token)){
            httpHeaders.add("token",token);
        }
        HttpEntity<Object> httpEntity = new HttpEntity<>(param,httpHeaders);
        Result result ;
        try {
            ResponseEntity<Result> resultResponseEntity = restTemplate.postForEntity(url, httpEntity, Result.class);
            result = resultResponseEntity.getBody();
            log.info("调用接口返回值=="+result.toString());
        }catch (Exception e){
            log.error("调用接口报错==="+e.getMessage());
            throw new RuntimeException();
        }
        return result;
    }

    public Result doGet(String url ,Map<String,Object> param ,String token){
        log.info("调用url==="+url+"  \n 参数=="+param);
        Result result ;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        if (!StringUtils.isEmpty(token)){
            headers.add("token",token);
        }
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
        param.entrySet().stream().forEach(o-> builder.queryParam(o.getKey(),o.getValue()));
        url = builder.build().encode().toString();
        try {
            JSONObject forObject = restTemplate.getForObject(url, JSONObject.class);
            log.info("调用接口返回值===="+forObject);
            result =JSONObject.toJavaObject(forObject,Result.class);
        }catch (Exception e){
            log.error("调用get报错==="+e.getMessage());
            throw new RuntimeException();
        }
        return result;
    }


}
