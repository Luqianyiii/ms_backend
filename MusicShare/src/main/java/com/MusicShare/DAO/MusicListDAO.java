package com.MusicShare.DAO;

import com.MusicShare.Model.MusicList;

import java.util.List;

public interface MusicListDAO {
    List<MusicList> getMusicListByUserId(int userId); // 获取用户的歌单

    boolean addMusicToList(MusicList musicList); // 添加歌曲到歌单

    boolean removeMusicFromList(int musicListId); // 从歌单中移除歌曲

    boolean updateMusicList(MusicList musicList); // 更新歌单信息
}
