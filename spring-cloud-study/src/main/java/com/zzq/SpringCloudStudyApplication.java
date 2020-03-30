package com.zzq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStudyApplication.class, args);
    }

}
