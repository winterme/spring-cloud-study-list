package com.zzq.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzq.util.JsonResult;
import org.apache.tomcat.util.http.MimeHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.HashMap;

@Controller
public class GetDataController {

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/getData")
    @ResponseBody
    public Object getData(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "zhangzq");
        map.put("job", "dev");

        return map;
    }

    /**
     * 修改header信息，key-value键值对儿加入到header中
     * @param request
     * @param key
     * @param value
     */
    private void reflectSetparam(HttpServletRequest request,String key,String value){
        Class<? extends HttpServletRequest> requestClass = request.getClass();
        System.out.println("request实现类="+requestClass.getName());
        try {
            Field request1 = requestClass.getDeclaredField("request");
            request1.setAccessible(true);
            Object o = request1.get(request);
            Field coyoteRequest = o.getClass().getDeclaredField("coyoteRequest");
            coyoteRequest.setAccessible(true);
            Object o1 = coyoteRequest.get(o);
            System.out.println("coyoteRequest实现类="+o1.getClass().getName());
            Field headers = o1.getClass().getDeclaredField("headers");
            headers.setAccessible(true);
            MimeHeaders o2 = (MimeHeaders)headers.get(o1);
            o2.addValue(key).setString(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
