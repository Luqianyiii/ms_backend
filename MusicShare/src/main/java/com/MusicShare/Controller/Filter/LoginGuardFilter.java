package com.MusicShare.Controller.Filter;


import com.MusicShare.Controller.SessionManager;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/home")
public class LoginGuardFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if (user == null) {
            // 用户未登录，重定向到登录页
            response.sendRedirect(request.getContextPath() + "/user?method=login.html");
            return;
        }

        String username = user.toString();
        SessionManager.bindUserToSession(username, session);

        chain.doFilter(req, resp);
    }


    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
