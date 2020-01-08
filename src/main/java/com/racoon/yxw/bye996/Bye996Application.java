package com.racoon.yxw.bye996;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Bye996Application extends SpringBootServletInitializer {
    // extends SpringBootServletInitializer
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(Bye996Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Bye996Application.class, args);
    }

    @GetMapping("/test")
    public String test(){
        return "123";
    }
}
