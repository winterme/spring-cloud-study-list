package com.zzq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzq.po.UserInfo;
import com.zzq.service.UserInfoService;
import com.zzq.util.ControllerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Value("${server.port}")
    private String port;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/add")
    @ResponseBody
    public Object add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangzq");
        userInfo.setPassword("pkusoft");
        userInfo.setTitle("javaer,小菜鸟");
        int i = this.userInfoService.insert(userInfo);
        return i;
    }

    @RequestMapping("/getByName")
    @ResponseBody
    public Object getById(String name, HttpServletRequest request) throws IOException {

        HashMap<String, Object> data = new HashMap<>();
        data.put("port", port);
        data.put("token", request.getHeader("token"));
        data.put("data", this.userInfoService.selectByUserName(name));

        return data;
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public Object getAll() {
        return this.userInfoService.getAll();
    }

}
