package com.sunjy.secret.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderFirstController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public  String index(){

        return port+"连接成功！";
    }
}
