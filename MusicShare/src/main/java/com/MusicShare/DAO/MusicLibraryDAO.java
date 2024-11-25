package com.MusicShare.DAO;

import com.MusicShare.Model.MusicLibrary;

import java.util.List;

public interface MusicLibraryDAO {
    List<MusicLibrary> getAllMusic(); // 获取所有音乐

    boolean addMusic(MusicLibrary musicLibrary); // 添加音乐

    boolean removeMusic(int musicId); // 删除音乐

    boolean updateMusic(MusicLibrary musicLibrary); // 更新音乐信息
}
