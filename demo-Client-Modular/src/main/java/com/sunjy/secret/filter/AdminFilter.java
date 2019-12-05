package com.sunjy.secret.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Component
@WebFilter(filterName = "adminFilter", urlPatterns = { "/user/user_manager","/user/user_add"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        String  role=(String) session.getAttribute("role");
        if("admin".equals(role)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            response.sendRedirect("/expand/redirect/main");
        }


    }

    @Override
    public void destroy() {

    }
}

