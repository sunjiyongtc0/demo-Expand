package com.sunjy.secret.controller.menu;

import com.sunjy.secret.entity.Menu;
import com.sunjy.secret.entity.ResultVO;
import com.sunjy.secret.entity.Type;
import com.sunjy.secret.feign.menu.MenuFeign;
import com.sunjy.secret.feign.menu.TypeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuFeign mf;
    @Autowired
    private TypeFeign tf;
    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @RequestMapping("/menu_manage")
    public String manager(){
        return "menu_manage";
    }

    @ResponseBody
    @GetMapping("/findAll")
    public ResultVO findall(@RequestParam("page") int page, @RequestParam("limit") int limit){
        List<Menu> lu=mf.menuFindAll((page-1)*limit,limit);
        int count=mf.menuCount();
        ResultVO r=new ResultVO(0,"数据接收成功",count,lu);
        return r;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") int id){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("menu_update");
        mav.addObject("menu",mf.menuFindById(id));
        mav.addObject("list",tf.typeFindAll());
        return mav;
    }
    @GetMapping("/deleteById/{id}")
    public  String deleteById(@PathVariable("id") int id ){
        mf.deleteById(id);
        return "redirect:/menu/redirect/menu_manage";
    }
    @PostMapping("/update")
    public  String update( Menu m){
        mf.updateMenu(m);
    return "/menu_manage";
}
@GetMapping("/menu_add/{id}")
    public ModelAndView add(@PathVariable("id") int id){
        ModelAndView mav= new ModelAndView();
        mav.setViewName("menu_add");
        List<Type> lt=tf.typeFindAll();
        for(Type t:lt){
            if(t.getId()==id){
                mav.addObject("type",t);
            }
        }
    return mav;
}
@PostMapping("/save")
    public  String  save(Menu m){
        mf.saveMenu(m);
        return "redirect:/menu/redirect/menu_manage";
}

}
