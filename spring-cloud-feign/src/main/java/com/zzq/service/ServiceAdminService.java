package com.zzq.service;

import com.zzq.interceptor.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-admin", configuration = FeignInterceptor.class, fallback = ServiceAdminServiceError.class)
public interface ServiceAdminService {

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public Object getByName(@RequestParam("name")String name);

}
