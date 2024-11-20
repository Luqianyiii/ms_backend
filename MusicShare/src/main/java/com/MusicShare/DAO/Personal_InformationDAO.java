package com.MusicShare.DAO;

import com.MusicShare.Model.Personal_Information;

import java.sql.SQLException;
import java.util.List;

public interface Personal_InformationDAO {
    // 插入一个用户
    void insertUser(Personal_Information user) throws SQLException;

    // 根据用户ID查询用户
    Personal_Information getUserById(int userId) throws SQLException;

    // 更新用户信息


    void updateUser(Personal_Information user) throws SQLException;

    // 删除用户
    void deleteUser(int userId) throws SQLException;

    // 获取所有用户
    List<Personal_Information> getAllUsers() throws SQLException;
}

