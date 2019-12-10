package com.sunjy.secret.feign.order;

import com.sunjy.secret.entity.Order;
import com.sunjy.secret.fallback.order.OrderFallback;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value ="order-server",fallback = OrderFallback.class)//这里的"menu"为服务配置中注册的服务名
public interface OrderFeign {

    @GetMapping("/order/findAllByUid/{page}/{limit}/{uid}/{role}")//这里的path指代除去ip端口后的url路径
    public List<Order> findAllByUid(@PathVariable("page") int page, @PathVariable("limit") int limit, @PathVariable("uid") long uid, @PathVariable("role") String role);

    @PostMapping("/order/save")
    public  void save(@RequestBody Order o);

    @GetMapping("/order/countByUid/{uid}/{role}")
    public  int countByUid(@PathVariable("uid") long uid,@PathVariable("role") String role);
}

