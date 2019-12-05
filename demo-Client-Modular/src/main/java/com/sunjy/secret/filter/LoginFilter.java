package com.sunjy.secret.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Component
@WebFilter(filterName = "loginFilter", urlPatterns = { "/*" })
/**
 * 配置登录拦截<br>
 * 如果页面没有角色，自动跳入登录页面
 * */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        String  role=(String) session.getAttribute("role");
        if(("".equals(role)||role==""||role==null )&& (request.getServletPath().indexOf("login")==-1)){
            response.sendRedirect("/expand/redirect/login");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
