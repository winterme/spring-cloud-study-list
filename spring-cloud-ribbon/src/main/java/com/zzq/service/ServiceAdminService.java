package com.zzq.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceAdminService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getUserByNameError")
    public String getUserByName(String username) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Accept", "*/*");

        HttpEntity<String> requestEntity = new HttpEntity<String>(null, requestHeaders);

        return this.restTemplate.exchange("http://service-admin/getByName?name=" + username, HttpMethod.GET, requestEntity, String.class).getBody();
    }

    /**
     * 熔断
     * getUserByName 方法的错误时候返回的数据
     *
     * @param username
     * @return
     */
    public String getUserByNameError(String username) {
        return String.format("request parameter is username：%s , but request bad!", username);
    }

}
