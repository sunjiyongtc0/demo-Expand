package com.sunjy.secret.controller;


import com.sunjy.secret.entity.Account;
import com.sunjy.secret.repository.AdminRepository;
import com.sunjy.secret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserRepository urepository;
    @Autowired
    private AdminRepository arepository;
    @Value("${server.port}")
    private String port;
    @GetMapping("/getp")
    public  String getPort(){
        return this.port;
    }
    @PostMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type){
        Account account = null;
        switch (type){
            case "user":
                account = urepository.login(username, password);
                break;
            case "admin":
                account = arepository.login(username, password);
                break;
        }
        return account;
    }



}
