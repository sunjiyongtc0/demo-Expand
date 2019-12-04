package com.sunjy.secret.controller.order;

import com.sunjy.secret.entity.*;
import com.sunjy.secret.feign.menu.MenuFeign;
import com.sunjy.secret.feign.menu.TypeFeign;
import com.sunjy.secret.feign.order.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
@Autowired
private OrderFeign of;
    @Autowired
    private MenuFeign mf;
    @Autowired
    private TypeFeign tf;
    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @RequestMapping("/order_manage")
    public String manager(){
        return "order";
    }

    @ResponseBody
    @GetMapping("findAllByUid")
    public ResultVO findByUid(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session){
    String role=(String)session.getAttribute("role");
        long uid=0;
    if("admin".equals(role)){
        uid=((Account)session.getAttribute("admin")).getId();
    }else{
        uid=((Account)session.getAttribute("user")).getId();
    }
        List<Order> lo=of.findAllByUid(page,limit,uid,role);
        int count=of.countByUid(uid,role);
        ResultVO r=new ResultVO(0,"数据接收成功",count,lo);
        return r;
    }

    @GetMapping("/add/{id}")
    public ModelAndView add(@PathVariable("id") int id){
        ModelAndView mav= new ModelAndView();
        mav.setViewName("order_add");
        mav.addObject("menu",mf.menuFindById(id));
        mav.addObject("list",tf.typeFindAll());
        return mav;
    }
@PostMapping("/save")
    public  String  save(Order o,Menu m,HttpSession session){
    o.setDate(new Date());
    Account a=(Account)session.getAttribute("user");
User u=new User();
u.setId(a.getId());
u.setUsername(a.getUsername());
    o.setUser(u);
    o.setMenu(m);
    System.out.println(o.getRemarks());
    of.save(o);
    return "redirect:/order/redirect/order";
}

//
//    @GetMapping("/findById/{id}")
//    public ModelAndView findById(@PathVariable("id") int id){
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("menu_update");
//        mav.addObject("menu",mf.menuFindById(id));
//        mav.addObject("list",tf.typeFindAll());
//        return mav;
//    }
//    @GetMapping("/deleteById/{id}")
//    public  String deleteById(@PathVariable("id") int id ){
//        mf.deleteById(id);
//        return "redirect:/menu/redirect/menu_manage";
//    }
//    @PostMapping("/update")
//    public  String update( Menu m){
//        mf.updateMenu(m);
//    return "/menu_manage";
//}



}
