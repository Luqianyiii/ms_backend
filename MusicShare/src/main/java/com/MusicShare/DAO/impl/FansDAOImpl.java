package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.FansDAO;
import com.MusicShare.Model.Fans;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FansDAOImpl implements FansDAO {
    private SqlSession sqlSession;

    @Override
    public List<Fans> getFansByPersonal_InformationId(int UserId) {
        return sqlSession.selectList("FansMapper.getFansByUserId", UserId);
    }


    @Override
    public boolean addFan(Fans fan) {
        int rows = sqlSession.insert("FansMapper.addFan", fan);
        return rows > 0;
    }

    @Override
    public boolean removeFan(int UserId, int fanId) {
        int rows = sqlSession.delete("FansMapper.removeFan", fanId);
        return rows > 0;
    }

    @Override
    public boolean isFanExists(int UserId, int fanId) {
        Integer count = sqlSession.selectOne("FansMapper.isFanExists", new Object[]{UserId, fanId});
        return count != null && count > 0;
    }
}
