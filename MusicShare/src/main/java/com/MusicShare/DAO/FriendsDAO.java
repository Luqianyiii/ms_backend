package com.MusicShare.DAO;

import com.MusicShare.Model.Friends;

import java.util.List;

public interface FriendsDAO {
    List<Friends> getUserId(int UserId); // 获取用户的朋友列表

    boolean addFriend(Friends friend); // 添加朋友

    boolean removeFriend(int friendId); // 移除朋友

    boolean isFriendExists(int Personal_InformationId, int friendId); // 判断是否已经是朋友
}
