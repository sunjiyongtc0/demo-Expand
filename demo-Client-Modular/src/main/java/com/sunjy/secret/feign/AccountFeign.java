package com.sunjy.secret.feign;

import com.sunjy.secret.entity.Account;
import com.sunjy.secret.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "account-server")//这里的"menu"为服务配置中注册的服务名
public interface AccountFeign {

    @PostMapping("/account/login/{username}/{password}/{type}")//这里的path指代除去ip端口后的url路径
    public Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);

}
