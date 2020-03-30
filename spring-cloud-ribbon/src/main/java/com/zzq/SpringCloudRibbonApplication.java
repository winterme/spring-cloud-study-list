package com.zzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@EnableHystrix  // 开启熔断支持
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonApplication.class, args);
    }

}
