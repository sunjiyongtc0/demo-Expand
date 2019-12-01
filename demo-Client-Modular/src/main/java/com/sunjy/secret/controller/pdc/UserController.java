package com.sunjy.secret.controller.pdc;

import com.sunjy.secret.entity.Account;
import com.sunjy.secret.entity.ResultVO;
import com.sunjy.secret.entity.User;
import com.sunjy.secret.feign.pdc.PdcFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PdcFeign pf;
    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @RequestMapping("/user_manage")
    public String manager(){
    return "user_manager";
    }
    @ResponseBody
    @GetMapping("/findAll")
    public  ResultVO findall(@RequestParam("page") int page,@RequestParam("limit") int limit){
        List<User> lu=pf.userFindAll((page-1)*limit,limit);
        int count=pf.userCount();
        ResultVO r=new ResultVO(0,"数据接收成功",count,lu);
    return r;
    }
    @GetMapping("/user_add")
    public  String userAdd(){
        return "user_add";
    }
    @PostMapping("/save")
    public String save(){
        System.out.println("save");

        return "redirect:/user/redirect/user_manage";
    }
    @GetMapping("/deleteAll")
    public  String deleteAll(){
        System.out.println("deleteAll");
        return "redirect:/user/redirect/user_manage";
    }
}
