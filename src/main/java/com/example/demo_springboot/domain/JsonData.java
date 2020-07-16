package com.example.demo_springboot.domain;
/*
 * @author: Jiuye
 * @date: 2020-07-16 23:17
 * @package: com.example.demo_springboot.domain
 * @Description: Json结果返回
 *
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
//@Data lombok插件自动生成get set方法
//@AllArgsConstructor 自动生成构造方法
public class JsonData implements Serializable {
    private static final long serialVersionUID = 1L;

    //状态码 0表示成功 -1表示失败
    private int code;

    //结果
    private Object data;

    //消息
    private String msg;

    public JsonData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
