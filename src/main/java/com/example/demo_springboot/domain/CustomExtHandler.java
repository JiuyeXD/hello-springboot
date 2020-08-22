package com.example.demo_springboot.domain;
/*
 * @author: Jiuye
 * @date: 2020-07-21 14:25
 * @package: com.example.demo_springboot.domain
 * @Description: 异常捕获实体类
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExtHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExtHandler.class);

    //捕获全局异常 处理所有不可知的异常
    @ExceptionHandler(value = Exception.class)
    Object handleExcption(Exception e, HttpServletRequest request){
        LOG.error("url {}, msg {}",request.getRequestURL(),e.getMessage());
        Map<String, Object> map = new HashMap<>();
        map.put("code",100);
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURL());
        return map;
    }

    //处理自定义异常
    @ExceptionHandler(value = MyException.class)
    Object handleMyException(MyException e,HttpServletRequest request){
//      ModelAndView modelAndView = new ModelAndView();
//      modelAndView.setViewName("error.html");
//      modelAndView.addObject("msg",e.getMessage());
//      return modelAndView;

        Map<String, Object> map = new HashMap<>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg()                );
        map.put("url",request.getRequestURL());
        return map;
    }
}
