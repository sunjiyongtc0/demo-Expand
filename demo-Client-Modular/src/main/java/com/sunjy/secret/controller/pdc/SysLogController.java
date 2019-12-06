package com.sunjy.secret.controller.pdc;


import com.sunjy.secret.aspect.MyLog;
import com.sunjy.secret.entity.ResultVO;
import com.sunjy.secret.entity.SysLog;
import com.sunjy.secret.entity.User;
import com.sunjy.secret.feign.pdc.PdcFeign;
import com.sunjy.secret.repository.SysLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SysLogController {
    @Autowired
    private SysLogRepository slr;
    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target){
        return target;
    }

    @RequestMapping("/syslog_manage")
    public String manager(){
    return "syslog_manage";
    }
    @ResponseBody
    @GetMapping("/findAll")
    public  ResultVO findall(@RequestParam("page") int page,@RequestParam("limit") int limit){
        List<SysLog> ls=slr.findAll((page-1)*limit,limit);
        int count=slr.count();
        ResultVO r=new ResultVO(0,"数据接收成功",count,ls);
    return r;
    }

}
