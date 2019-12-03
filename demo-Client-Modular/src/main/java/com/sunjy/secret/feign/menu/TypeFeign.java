package com.sunjy.secret.feign.menu;

import com.sunjy.secret.entity.Menu;
import com.sunjy.secret.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value ="menu-server")//这里的"menu"为服务配置中注册的服务名
public interface TypeFeign {

    @GetMapping("/type/findAll")//这里的path指代除去ip端口后的url路径
    public List<Type> typeFindAll();

}

