package com.zzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

/**
 * 将该服务注册到 eureka上，并被发现
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard //熔断器仪表盘支持
//@EnableHystrix
public class SpringCloudFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFeignApplication.class,args);
    }


    /**
     * 添加 RequestContextListener，解决 RequestContextHolder .getRequestAttributes() 获取不到的bug
     * @return
     */
    /*@Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }*/

}
