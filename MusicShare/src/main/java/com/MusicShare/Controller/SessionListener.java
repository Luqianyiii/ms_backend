package com.MusicShare.Controller;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        // 可在会话创建时进行日志记录或预处理逻辑
        System.out.println("Session Created: " + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        Object user = session.getAttribute("user");

        if (user != null) {
            // 清理会话管理器中存储的用户会话信息
            SessionManager.removeSession(user.toString());
            System.out.println("Session Destroyed for User: " + user);
        }
    }
}
