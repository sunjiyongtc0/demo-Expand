package com.sunjy.secret.controller;


import com.sunjy.secret.entity.Account;
import com.sunjy.secret.entity.Admin;
import com.sunjy.secret.entity.User;
import com.sunjy.secret.repository.AdminRepository;
import com.sunjy.secret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    @GetMapping("findAll/{begin}/{end}")
    public List<User> findAll(@PathVariable("begin") int begin ,@PathVariable("end") int end){
        List<User> lu=urepository.findAll(begin,end);
     return  lu;
}

    @GetMapping("/findCount")
    public  int count(){
        int count=urepository.count();
    return  count;
    }
    @PostMapping("/saveUser")
    public void save(@RequestBody User u){
        u.setRegisterdate(new Date());
        urepository.save(u);
    }
    @PostMapping("/saveAdmin")
    public void save(@RequestParam Admin a){
        arepository.save(a);
    }

    @DeleteMapping("/deletebyid/{id}")
    public  void delete(@PathVariable("id") long id){
        urepository.deleteById(id);
    }
    @GetMapping("/findById/{id}")
    public  User findById(@PathVariable("id") long id){
            User u=urepository.findById(id);
        return u;
    }
    @PostMapping("/updateUser")
    public  void updateUser(@RequestBody User user){
        urepository.updateUser(user);
    }

}
