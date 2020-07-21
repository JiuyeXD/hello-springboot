package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.MyException;
import com.example.demo_springboot.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
 * @author: Jiuye
 * @date: 2020-07-21 14:16
 * @package: com.example.demo_springboot.controller
 * @Description: 异常捕获
 */

@RestController
public class ExcptionController {
    //模拟全局异常
    @RequestMapping("/v1/test_ext")
    public Object testExt(){
        int a = 1/0;
        return new User(a,"abc","a","10010",new Date());
    }
    //模拟自定义异常
    @RequestMapping("/v1/myext")
    public Object myexc(){
        throw new MyException("499","my ext异常");
    }
}

