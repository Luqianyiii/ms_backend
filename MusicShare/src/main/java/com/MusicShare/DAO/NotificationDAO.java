package com.MusicShare.DAO;

import com.MusicShare.Model.Notification;

import java.util.List;

public interface NotificationDAO {
    List<Notification> getNotificationsByUserId(int userId); // 获取用户的通知

    boolean addNotification(Notification notification); // 添加通知

    boolean deleteNotification(int notificationId); // 删除通知

    boolean updateNotification(Notification notification); // 更新通知
}
