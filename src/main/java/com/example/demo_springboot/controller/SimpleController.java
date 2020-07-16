package com.example.demo_springboot.controller;
/*
 * @author: Jiuye
 * @date: 2020-07-16 13:19
 * @package: com.example.demo_springboot.controller
 * @Description:
 */

import com.example.demo_springboot.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController //包含了@RequestBody
public class SimpleController {

    @RequestMapping("/hello")
    //@RequestBody
    public String hello(){
        return "hello spring boot";
    }

    @RequestMapping("/testDemo")
    public Map<String,String> test(){
        Map<String,String> map = new HashMap<>();
        map.put("name","name_demo");
        map.put("time",new Date().toString());
        return map;
    }

    @RequestMapping("/testjson")
    public Object testJson(){
        return new User(1,null,"pwd","10086",new Date());
    }
}
