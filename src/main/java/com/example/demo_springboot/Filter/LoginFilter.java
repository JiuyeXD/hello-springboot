package com.example.demo_springboot.Filter;
/*
 * @author: Jiuye
 * @date: 2020-08-10 16:33
 * @package: ${PACKAGE_NAME}
 * @Description:过滤器
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/v1/*", filterName = "LoginFilter")
public class LoginFilter implements Filter {
    //容器加载的时候调用
    @Override
    public void destroy() {
        System.out.println("destroy loginFilter");
    }
    //请求被拦截调用
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("do loginFilter");

        String username = req.getParameter("username");
        if ("username".equals(username)){
            chain.doFilter(req,resp);
        }else{
            chain.doFilter(req,resp);//正常来说这行不应该存在 因为方便后面测试别的功能暂时添加
            return;
        }
    }
    //容器销毁的时候调用
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init loginFilter");
    }

}
