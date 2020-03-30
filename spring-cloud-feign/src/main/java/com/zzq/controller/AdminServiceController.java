package com.zzq.controller;

import com.zzq.service.ServiceAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminServiceController {

    @Autowired
    private ServiceAdminService serviceAdminService;

    @RequestMapping("/getUserByUserName")
    @ResponseBody
    public Object getUserByUserName(String name){

        return serviceAdminService.getByName(name);
    }

}
