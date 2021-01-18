package com.xiaoxie.gym.place.util;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @create 2020-06-17  16:06
 */
public class GetUser {

    public static User getUser(Integer id){
        User user = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            //将指定的url返回的参数自动封装到自定义好的对应类对象中
            ReturnMsg returnMsg = restTemplate.getForObject("http://47.116.67.43:8001//user/{id}", ReturnMsg.class,id);
            user = returnMsg.getData();
        }catch (HttpClientErrorException e){
            System.out.println("http客户端请求出错了！");
            //开发中可以使用统一异常处理，或者在业务逻辑的catch中作响应
        }
        return user;
    }
}
