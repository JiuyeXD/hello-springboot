package com.example.demo_springboot.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * @author: Jiuye
 * @date: 2020-07-20 23:49
 * @package: com.example.demo_springboot.domain
 * @Description: 服务器实体类配置
 */
@Data
@Component
@PropertySource({"classpath:static/config/ServerSettings.properties"})
@ConfigurationProperties
public class ServerSettings {
    //名称
    @Value("${test.name}")
    private String name;
    //域名地址
    @Value("${test.domain}")
    private String domain;
}

