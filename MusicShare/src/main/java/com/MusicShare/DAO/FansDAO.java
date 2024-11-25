package com.MusicShare.DAO;

import com.MusicShare.Model.Fans;
import com.MusicShare.Model.Personal_Information;

import java.util.List;

public interface FansDAO {
    List<Fans> getFansByPersonal_InformationId(int Personal_InformationId); // 根据用户ID获取粉丝列表


    boolean addFan(Fans fan);

    boolean removeFan(int Personal_InformationId, int fanId); // 删除粉丝


    boolean isFanExists(int Personal_InformationId, int fanId); // 判断是否已经是粉丝
}
