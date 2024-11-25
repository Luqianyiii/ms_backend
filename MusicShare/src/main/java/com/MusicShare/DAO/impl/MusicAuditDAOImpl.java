package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.MusicAuditDAO;
import com.MusicShare.Model.MusicAudit;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MusicAuditDAOImpl implements MusicAuditDAO {
    private SqlSession sqlSession;

    @Override
    public List<MusicAudit> getAuditRecordsByMusicId(int musicId) {
        return sqlSession.selectList("MusicAuditMapper.getAuditRecordsByMusicId", musicId);
    }

    @Override
    public boolean addAuditRecord(MusicAudit musicAudit) {
        int rows = sqlSession.insert("MusicAuditMapper.addAuditRecord", musicAudit);
        return rows > 0;
    }

    @Override
    public boolean deleteAuditRecord(int auditId) {
        int rows = sqlSession.delete("MusicAuditMapper.deleteAuditRecord", auditId);
        return rows > 0;
    }

    @Override
    public boolean updateAuditRecord(MusicAudit musicAudit) {
        int rows = sqlSession.update("MusicAuditMapper.updateAuditRecord", musicAudit);
        return rows > 0;
    }
}
