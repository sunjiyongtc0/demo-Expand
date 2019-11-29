package com.sunjy.secret.controller.login;


import com.alibaba.fastjson.JSONObject;
import com.sunjy.secret.entity.Account;
import com.sunjy.secret.entity.ResultVO;
import com.sunjy.secret.feign.AccountFeign;
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

//    @PostMapping("/loginto/{username}/{password}/{type}")
//    public String loging(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type,HttpSession session) {
    @PostMapping("/loginto")
    public String loging(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type,HttpSession session) {
        String target = null;
        System.out.println(username);
        Account ac = af.login(username, password, type);
        if (ac.getId() < 0) {
            target = "login";
        } else {
            switch (type){
                case "user":
                    session.setAttribute("user",ac);
                    target = "redirect:/expand/redirect/index";
                    break;
                case "admin":
                    session.setAttribute("admin",ac);
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
