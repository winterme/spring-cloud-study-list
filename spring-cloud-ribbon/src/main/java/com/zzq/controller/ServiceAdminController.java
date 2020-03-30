package com.zzq.controller;

import com.zzq.service.ServiceAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAdminController {

    @Autowired
    private ServiceAdminService serviceAdminService;

    @RequestMapping("/getUserByUserName")
    public Object getUserByUserName(String name){
        return serviceAdminService.getUserByName(name);
    }

}
