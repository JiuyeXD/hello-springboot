package com.example.demo_springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * @author: Jiuye
 * @date: 2020-07-21 14:50
 * @package: com.example.demo_springboot.domain
 * @Description:
 */
@Data
@AllArgsConstructor
public class MyException extends RuntimeException {
    private String code;
    private String msg;
}
