package com.sunjy.secret.controller;

import com.sunjy.secret.entity.Menu;
import com.sunjy.secret.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientFirstController {
    @Autowired
    private MenuFeign mf;

    @GetMapping("/index")
    public  String index(){

        return "client连接成功！";
    }
    @GetMapping("/find")
    public List<Menu> findmenu(){

        return mf.findAll();
    }

}
