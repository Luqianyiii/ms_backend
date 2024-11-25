package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.NotificationDAO;
import com.MusicShare.Model.Notification;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NotificationDAOImpl implements NotificationDAO {
    private SqlSession sqlSession;

    @Override
    public List<Notification> getNotificationsByUserId(int userId) {
        return sqlSession.selectList("NotificationMapper.getNotificationsByUserId", userId);
    }

    @Override
    public boolean addNotification(Notification notification) {
        int rows = sqlSession.insert("NotificationMapper.addNotification", notification);
        return rows > 0;
    }

    @Override
    public boolean deleteNotification(int notificationId) {
        int rows = sqlSession.delete("NotificationMapper.deleteNotification", notificationId);
        return rows > 0;
    }

    @Override
    public boolean updateNotification(Notification notification) {
        int rows = sqlSession.update("NotificationMapper.updateNotification", notification);
        return rows > 0;
    }
}
