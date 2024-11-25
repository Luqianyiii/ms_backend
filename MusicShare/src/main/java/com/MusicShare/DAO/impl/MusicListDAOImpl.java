package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.MusicListDAO;
import com.MusicShare.Model.MusicList;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MusicListDAOImpl implements MusicListDAO {
    private SqlSession sqlSession;

    @Override
    public List<MusicList> getMusicListByUserId(int userId) {
        return sqlSession.selectList("MusicListMapper.getMusicListByUserId", userId);
    }

    @Override
    public boolean addMusicToList(MusicList musicList) {
        int rows = sqlSession.insert("MusicListMapper.addMusicToList", musicList);
        return rows > 0;
    }

    @Override
    public boolean removeMusicFromList(int musicListId) {
        int rows = sqlSession.delete("MusicListMapper.removeMusicFromList", musicListId);
        return rows > 0;
    }

    @Override
    public boolean updateMusicList(MusicList musicList) {
        int rows = sqlSession.update("MusicListMapper.updateMusicList", musicList);
        return rows > 0;
    }
}