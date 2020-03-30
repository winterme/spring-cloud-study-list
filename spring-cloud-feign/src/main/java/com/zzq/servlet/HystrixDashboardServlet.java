package com.zzq.servlet;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.metric.consumer.HystrixDashboardStream;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.Servlet;

@Component
public class HystrixDashboardServlet {

    @Bean
    public ServletRegistrationBean setServlet(){
        ServletRegistrationBean<Servlet> bean = new ServletRegistrationBean<>();
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        bean.setServlet(servlet);
        bean.setLoadOnStartup(1);
        bean.addUrlMappings("/h.s");

        return bean;
    }

}
