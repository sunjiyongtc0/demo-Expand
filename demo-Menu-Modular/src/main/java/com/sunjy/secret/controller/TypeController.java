package com.sunjy.secret.controller;


import com.sunjy.secret.entity.Type;
import com.sunjy.secret.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private TypeRepository tr;

    @GetMapping("/index")
    public  String index(){
        return port+"连接成功！";
    }
    @GetMapping("/findAll")
    public List<Type> findType(){
        return tr.findAll();
    }

}
