package com.sunjy.secret.fallback.order;

import com.sunjy.secret.entity.Order;
import com.sunjy.secret.feign.order.OrderFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderFallback implements OrderFeign {
    @Override
    public List<Order> findAllByUid(int page, int limit, long uid, String role) {
        System.out.println("进入熔断！");
        List<Order> l=new ArrayList<Order>();
        return l;
    }

    @Override
    public void save(Order o) {

    }

    @Override
    public int countByUid(long uid, String role) {
        return 0;
    }
}
