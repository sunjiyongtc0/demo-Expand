package com.sunjy.secret.aspect;

import com.alibaba.fastjson.JSON;
import com.sunjy.secret.entity.Account;
import com.sunjy.secret.entity.SysLog;
import com.sunjy.secret.util.IpUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

//    @Autowired
//    private SysLogService sysLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.sunjy.secret.aspect.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面。。。。。");
        //保存日志
        SysLog sysLog = new SysLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            sysLog.setOperation(value);//保存获取的操作
            System.out.println(sysLog.getOperation());//--------------------------------------
        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        sysLog.setMethod(className + "." + methodName);
        System.out.println(sysLog.getMethod());//-----------------------------------------------
        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        sysLog.setParams(params);
        System.out.println(sysLog.getParams());//-----------------------------------
        sysLog.setCreateDate(new Date());
        System.out.println(sysLog.getCreateDate());//------------------------------------------
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session= request.getSession();
        //获取用户名
        String role=(String)session.getAttribute("role");
        if("admin".equals(role)){
            Account a=(Account) session.getAttribute("admin");
            sysLog.setUsername((String)a.getUsername());
        }else if("user".equals(role)){
            Account a=(Account) session.getAttribute("user");
            sysLog.setUsername((String)a.getUsername());
        }
        System.out.println(sysLog.getUsername());
//        //获取用户ip地址
        sysLog.setIp(IpUtil.getIpAddr(request));
        System.out.println(sysLog.getIp());//-------------------------------------------------



        //调用service保存SysLog实体类到数据库
//        sysLogService.save(sysLog);
    }

}