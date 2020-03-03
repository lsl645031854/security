package com.jetty.homolo.security.http;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.Supplier;

public class RestTemplateUtils {

    private static Logger log = LoggerFactory.getLogger(RestTemplateUtils.class);

    /**
     * 极光专用restTemplate
     */
    private static RestTemplate restTemplate;
    //幂等控制 rediskey 格式：JPUSH:regId:notification的hashcode
    private static final String JPUSH_IDEMPOTENT = "JPUSH:%s:%s";
    private static final int EXPIRE_TIME = 60;//s

    public static void setRestTemplate(RestTemplate restTemplate) {
        RestTemplateUtils.restTemplate = restTemplate;
    }

    public static <T> T get(String url,Class<T> t){
        return execute(url,null,()-> {
            ResponseEntity<T> forEntity = restTemplate.getForEntity(url, t);
            return forEntity.getBody();
        });
    }

    public static <T> T get(String url,Class<T> t,Map<String ,?> params){
        return execute(url,params,()-> {
            ResponseEntity<T> forEntity = restTemplate.getForEntity(url, t, params);
            return forEntity.getBody();
        });
    }

    public static <T> T post(String url, Class<T> t, JSONObject param){
        return execute(url,param,()->{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
            HttpEntity<Object> objectHttpEntity = new HttpEntity<>(param,httpHeaders);
            ResponseEntity<T> forEntity = restTemplate.postForEntity(url, objectHttpEntity, t);
            return forEntity.getBody();
        });
    }

    /**
     * 执行器
     * @param supplier
     * @param <T>
     * @return
     */
    private static <T> T execute(String url,Object param,Supplier<T> supplier){
        try{
            T t = supplier.get();
            log.info("极光接口==>{},请求参数==>{},响应结果==>{}",url, JSON.toJSONString(param), JSON.toJSONString(t));
            return t;
        }catch (Exception e){
            log.error("调用极光接口异常==>"+url+",参数==>"+ JSON.toJSONString(param),e);
            return null;
        }
    }

}
