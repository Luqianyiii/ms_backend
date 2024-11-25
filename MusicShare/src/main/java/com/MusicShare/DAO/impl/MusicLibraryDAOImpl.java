package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.MusicLibraryDAO;
import com.MusicShare.Model.MusicLibrary;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MusicLibraryDAOImpl implements MusicLibraryDAO {
    private SqlSession sqlSession;

    @Override
    public List<MusicLibrary> getAllMusic() {
        return sqlSession.selectList("MusicLibraryMapper.getAllMusic");
    }

    @Override
    public boolean addMusic(MusicLibrary musicLibrary) {
        int rows = sqlSession.insert("MusicLibraryMapper.addMusic", musicLibrary);
        return rows > 0;
    }

    @Override
    public boolean removeMusic(int musicId) {
        int rows = sqlSession.delete("MusicLibraryMapper.removeMusic", musicId);
        return rows > 0;
    }

    @Override
    public boolean updateMusic(MusicLibrary musicLibrary) {
        int rows = sqlSession.update("MusicLibraryMapper.updateMusic", musicLibrary);
        return rows > 0;
    }
}
