package com.sunjy.secret.feign.pdc;

import com.sunjy.secret.entity.Account;
import com.sunjy.secret.entity.Admin;
import com.sunjy.secret.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "account-server")//这里的"menu"为服务配置中注册的服务名
public interface PdcFeign {

    @GetMapping("/account/findAll/{begin}/{end}")//这里的path指代除去ip端口后的url路径
    public List<User> userFindAll(@PathVariable("begin") int  begin, @PathVariable("end") int end);

    @GetMapping("/account/findCount")
    public int userCount();

    @PostMapping("/account/saveUser")
    public void saveUser(@RequestBody User u);

    @PostMapping("/account/saveAdmin")
    public void saveAdmin(@RequestBody Admin a);

    @DeleteMapping("/account/deletebyid/{id}")
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/account/findById/{id}")
    public User findById(@PathVariable("id") long id);

    @PostMapping("/account/updateUser")
    public void updateUser(@RequestBody User u);
}
