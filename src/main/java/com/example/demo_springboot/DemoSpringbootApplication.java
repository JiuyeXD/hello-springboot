package com.example.demo_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

//@SpringBootApplication 一个顶下面三个
@SpringBootConfiguration
@EnableAutoConfiguration
@Component

public class DemoSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory f = new MultipartConfigFactory();
        //设置单个文件的最大值
        f.setMaxFileSize(DataSize.parse("5MB"));
        //设置上传数据的总大小
        f.setMaxRequestSize(DataSize.parse("50MB"));
        return f.createMultipartConfig();

    }

}
