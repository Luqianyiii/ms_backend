package com.MusicShare;

import com.MusicShare.DAO.Personal_InformationDAO;
import com.MusicShare.Model.Personal_Information;
import com.MusicShare.DAO.impl.PersonalInformationDAOImpl;
import com.MusicShare.Utils.DatabaseConnection;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {


        public static void main(String[] args) {
            // 假设已经建立了数据库连接
            Connection connection = null;
            try {
                connection = DatabaseConnection.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // 使用接口引用来操作
            Personal_InformationDAO personalInformationDAO = new PersonalInformationDAOImpl(connection);

            // 插入一个新用户
            try {
                Personal_Information user = new Personal_Information();
                user.setName("John Doe");
                user.setEmail("john@example.com");
                user.setPassword("password123");

                personalInformationDAO.insertUser(user);

                System.out.println("User inserted successfully");

                // 获取所有用户
                List<Personal_Information> personalInformationList = personalInformationDAO.getAllUsers();
                for (Personal_Information u : personalInformationList) {
                    System.out.println("User ID: " + u.getId() + ", Name: " + u.getName());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



