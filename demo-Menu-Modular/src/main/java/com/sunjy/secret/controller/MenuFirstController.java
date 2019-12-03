package com.sunjy.secret.controller;

import com.sunjy.secret.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/findAll/{begin}/{end}")
    public List<Menu> findmenu(@PathVariable("begin") int begin,@PathVariable("end") int end){
        return mr.findAll(begin,end);
    }

    @GetMapping("/findCount")
    public  int findCount(){
        return  mr.count();
    }
    @GetMapping("/findById/{id}")
    public  Menu findById(@PathVariable("id") int id){
        return mr.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        mr.deleteById(id);
    }
    @PostMapping("/saveMenu")
    public void save(@RequestBody Menu menu){
        mr.save(menu);
    }
    @PostMapping("/updateMenu")
    public void update(@RequestBody Menu m){
        mr.update(m);
    }
}
