package com.zzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 将该服务注册到 eureka上，并被发现
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudServiceAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceAdminApplication.class,args);
    }

}
