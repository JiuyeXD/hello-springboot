package com.example.demo_springboot.domain;
/*
 * @author: Jiuye
 * @date: 2020-07-16 13:18
 * @package: com.example.demo_springboot.domain
 * @Description:
 */

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data                              //get，set
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class User {

    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL) //空字段不返回
    private String name;

    @JsonIgnore //不返回此字段
    private String pwd;

    @JsonProperty("account") //别名
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

}
