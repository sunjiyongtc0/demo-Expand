package com.sunjy.secret;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sunjy.secret.repository")
public class MenuModularApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuModularApplication.class,args);
    }
}
