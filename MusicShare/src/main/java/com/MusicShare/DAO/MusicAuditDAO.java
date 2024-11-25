package com.MusicShare.DAO;

import com.MusicShare.Model.MusicAudit;

import java.util.List;

public interface MusicAuditDAO {
    List<MusicAudit> getAuditRecordsByMusicId(int musicId); // 根据音乐ID获取审核记录

    boolean addAuditRecord(MusicAudit musicAudit); // 添加审核记录

    boolean deleteAuditRecord(int auditId); // 删除审核记录

    boolean updateAuditRecord(MusicAudit musicAudit); // 更新审核记录
}
