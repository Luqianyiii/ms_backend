package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.FriendsDAO;
import com.MusicShare.Model.Friends;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FriendsDAOImpl implements FriendsDAO {
    private SqlSession sqlSession;

    @Override
    public List<Friends> getUserId(int UserId) {
        return sqlSession.selectList("FriendsMapper.getFriendsByUserId", UserId);
    }

    @Override
    public boolean addFriend(Friends friend) {
        int rows = sqlSession.insert("FriendsMapper.addFriend", friend);
        return rows > 0;
    }

    @Override
    public boolean removeFriend(int friendId) {
        int rows = sqlSession.delete("FriendsMapper.removeFriend", friendId);
        return rows > 0;
    }

    @Override
    public boolean isFriendExists(int UserId, int friendId) {
        Integer count = sqlSession.selectOne("FriendsMapper.isFriendExists", new Object[]{UserId, friendId});
        return count != null && count > 0;
    }
}
