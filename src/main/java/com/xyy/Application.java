package com.xyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author user
 * @date 2021/5/3 - 16:56
 */
@SpringBootApplication
@MapperScan("com.xyy.dao")
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
