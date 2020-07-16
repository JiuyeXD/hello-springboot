package com.example.demo_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author: Jiuye
 * @date: 2020-07-16 16:19
 * @package: com.example.demo_springboot.controller
 * @Description:
 */
@Controller
public class FileController {
    @RequestMapping(value = "/")
    public Object Index(){
        return "index";
    }
}
