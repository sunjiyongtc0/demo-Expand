package com.sunjy.secret.controller;

import com.sunjy.secret.entity.Order;
import com.sunjy.secret.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderFirstController {
@Autowired
private OrderRepository or;
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public  String index(){

        return port+"连接成功！";
    }
@GetMapping("/findAllByUid/{page}/{limit}/{uid}/{role}")
public List<Order> findAllByUid(@PathVariable("page") int page, @PathVariable("limit") int limit, @PathVariable("uid") long uid, @PathVariable("role") String role) {
    return or.findAllByUid(uid, page, limit, role);
}
@GetMapping("/countByUid/{uid}/{role}")
public int countByUid(@PathVariable("uid") long uid,@PathVariable("role") String role){
    return or.countByUid(uid,role);
}


@PostMapping("/save")
public void save(@RequestBody Order o){
    System.out.println(o.getRemarks());
    or.save(o);
    }

}
