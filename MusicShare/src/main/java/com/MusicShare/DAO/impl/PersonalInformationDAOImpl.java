package com.MusicShare.DAO.impl;

import com.MusicShare.DAO.Personal_InformationDAO;
import com.MusicShare.Model.Personal_Information;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalInformationDAOImpl implements Personal_InformationDAO {

    private Connection connection;

    // 构造方法，传入数据库连接
    public PersonalInformationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertUser(Personal_Information user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
        }
    }


    @Override
    public Personal_Information getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Personal_Information user = new Personal_Information();
                    user.setUserId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public void updateUser(Personal_Information user) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getUserId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Personal_Information> getAllUsers() throws SQLException {
        List<Personal_Information> personalInformationList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Personal_Information user = new Personal_Information();
                user.setUserId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                personalInformationList.add(user);
            }
        }
        return personalInformationList;
    }
}
