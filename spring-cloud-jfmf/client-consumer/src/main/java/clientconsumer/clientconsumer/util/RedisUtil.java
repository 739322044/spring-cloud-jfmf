package clientconsumer.clientconsumer.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhbr
 * @title: RedisUtil
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2020/12/2415:28
 */
@Component

public class RedisUtil {

    private final static Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private static RedisTemplate<String,Object> redisTemplate ;

    public RedisUtil (RedisTemplate<String,Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public boolean exprie(String key,long time){
        Boolean expire ;
        try {
            if (time>0){
                return redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }

    public static boolean set(String key,String value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }
    public static Object get(String key){
        try {
            return redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public static  void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }
    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public static Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    public static void sSet(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);

    }

}
