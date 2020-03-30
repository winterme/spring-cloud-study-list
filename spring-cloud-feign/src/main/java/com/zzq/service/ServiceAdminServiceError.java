package com.zzq.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceAdminServiceError implements ServiceAdminService {
    @Override
    public Object getByName(String name) {
        return String.format("request parameter name is %s , but request bad!", name);
    }
}
