package com.sunjy.secret.feign.pdc;

import com.sunjy.secret.entity.Account;
import com.sunjy.secret.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "account-server")//这里的"menu"为服务配置中注册的服务名
public interface PdcFeign {

    @GetMapping("/account/findAll/{begin}/{end}")//这里的path指代除去ip端口后的url路径
    public List<User> userFindAll(@PathVariable("begin") int  begin, @PathVariable("end") int end);

    @GetMapping("/account/findCount")
    public int userCount();

}
