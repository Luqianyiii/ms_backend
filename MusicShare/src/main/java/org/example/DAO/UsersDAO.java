package org.example.DAO;

import org.example.VO.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    // 插入一个用户
    void insertUser(Users user) throws SQLException;

    // 根据用户ID查询用户
    Users getUserById(int userId) throws SQLException;

    // 更新用户信息


    void updateUser(Users user) throws SQLException;

    // 删除用户
    void deleteUser(int userId) throws SQLException;

    // 获取所有用户
    List<Users> getAllUsers() throws SQLException;
}

