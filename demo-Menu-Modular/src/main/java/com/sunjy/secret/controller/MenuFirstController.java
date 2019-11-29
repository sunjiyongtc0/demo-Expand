package com.sunjy.secret.controller;

import com.sunjy.secret.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sunjy.secret.entity.Menu;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuFirstController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository mr;

    @GetMapping("/index")
    public  String index(){

        return port+"连接成功！";
    }
    @GetMapping("/find")
    public List<Menu> findmenu(){

        return mr.findAll(0,10);
    }

}
