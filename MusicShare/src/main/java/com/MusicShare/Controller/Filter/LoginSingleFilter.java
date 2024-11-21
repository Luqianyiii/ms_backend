package com.MusicShare.Controller.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class LoginSingleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        Object currentUser = session.getAttribute("user");
        Object boundUser = session.getAttribute("boundUser");

        if (currentUser != null && boundUser != null && !currentUser.equals(boundUser)) {
            // 拦截绑定多个账号的行为
            response.getWriter().write("当前会话已绑定其他账号，无法登录新账号！");
            return;
        }

        if (currentUser != null && boundUser == null) {
            // 绑定当前用户
            session.setAttribute("boundUser", currentUser);
        }

        chain.doFilter(req, resp);
    }


    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}