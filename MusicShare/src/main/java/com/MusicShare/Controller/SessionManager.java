package com.MusicShare.Controller;


import jakarta.servlet.http.HttpSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {

    // 使用线程安全的 ConcurrentHashMap 存储用户会话信息
    private static final Map<String, HttpSession> userSessionMap = new ConcurrentHashMap<>();

    /**
     * 绑定用户和会话
     * @param username 用户名
     * @param session  会话
     */
    public static void bindUserToSession(String username, HttpSession session) {
        HttpSession oldSession = userSessionMap.put(username, session);

        // 如果存在旧会话，销毁旧会话
        if (oldSession != null && !oldSession.equals(session)) {
            oldSession.invalidate();
        }
    }

    /**
     * 移除用户绑定的会话
     * @param username 用户名
     */
    public static void removeSession(String username) {
        HttpSession session = userSessionMap.remove(username);

        if (session != null) {
            session.invalidate(); // 防止未被销毁的会话残留
        }
    }

    /**
     * 获取用户绑定的会话
     * @param username 用户名
     * @return 绑定的会话
     */
    public static HttpSession getUserSession(String username) {
        return userSessionMap.get(username);
    }

    /**
     * 判断会话是否已绑定其他用户
     * @param session 当前会话
     * @param username 当前用户名
     * @return 是否已绑定其他用户
     */
    public static boolean isSessionBoundToAnotherUser(HttpSession session, String username) {
        return userSessionMap.entrySet().stream()
                .anyMatch(entry -> entry.getValue().equals(session) && !entry.getKey().equals(username));
    }
}
