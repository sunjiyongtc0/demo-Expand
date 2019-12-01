package com.sunjy.secret.controller.login;


import com.sunjy.secret.entity.Account;
import com.sunjy.secret.feign.login.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/expand")
public class LoginController {
    private static String login="login";
    private static String main="main_bak";
    @Autowired
    private AccountFeign af;

    @GetMapping("/login")
    public String Index(){
    return this.login;
    }
    @PostMapping("/main")
    public String main(){
        return this.main;
    }

    @PostMapping("/loginto")
    public String loging(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type,HttpSession session) {
        String target = null;
        Account ac = af.login(username, password, type);
        if (ac==null) {
            target = "redirect:/expand/redirect/login";
        } else {
            switch (type){
                case "user":
                    session.setAttribute("user",ac);
                    session.setAttribute("role","user");
                    target = "redirect:/expand/redirect/main";
                    break;
                case "admin":
                    session.setAttribute("admin",ac);
                    session.setAttribute("role","admin");
                    target = "redirect:/expand/redirect/main";
                    break;
            }
        }
        return target;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }
}
