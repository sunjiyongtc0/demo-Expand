package com.sunjy.secret.controller;

import com.sunjy.secret.entity.Menu;
import com.sunjy.secret.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class ClientController {
    private final String index="index";
    @Autowired
    private MenuFeign mf;
    @GetMapping("/f")
    public String index(){
        return index;
    }
    @ResponseBody
    @GetMapping("/findf")
    public Map find(){
        List<Menu> lm=mf.findAll();
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","");
        map.put("count",100);
        map.put("data",lm);
        return map;
    }
@GetMapping("/te")
    public String getTest() {
        return "main";
    }
}
