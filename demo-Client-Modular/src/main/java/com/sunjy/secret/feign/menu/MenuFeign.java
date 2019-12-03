package com.sunjy.secret.feign.menu;

import com.sunjy.secret.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value ="menu-server")//这里的"menu"为服务配置中注册的服务名
public interface MenuFeign {

    @GetMapping("/menu/findAll/{begin}/{end}")//这里的path指代除去ip端口后的url路径
    public List<Menu> menuFindAll(@PathVariable("begin") int  begin, @PathVariable("end") int end);

    @GetMapping("/menu/findCount")
    public int menuCount();

    @GetMapping("/menu/findById/{id}")
    public Menu menuFindById(@PathVariable("id") long id);

    @DeleteMapping("/menu/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

    @PostMapping("/menu/saveMenu")
    public void saveMenu(@RequestBody Menu m);

    @PostMapping("/menu/updateMenu")
    public void updateMenu(@RequestBody Menu m);
}

