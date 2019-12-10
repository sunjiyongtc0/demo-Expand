package com.sunjy.secret.fallback.menu;

import com.sunjy.secret.entity.Type;
import com.sunjy.secret.feign.menu.TypeFeign;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TypeFallback implements TypeFeign {
    @Override
    public List<Type> typeFindAll() {
        System.out.println("进入熔断");
        return null;
    }
}
