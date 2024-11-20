package org.example;

import org.example.DAO.UsersDAO;
import org.example.IMPL.UsersDAOImpl;
import org.example.Utils.DatabaseConnection;
import org.example.VO.Users;


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
            UsersDAO usersDAO = new UsersDAOImpl(connection);

            // 插入一个新用户
            try {
                Users user = new Users();
                user.setName("John Doe");
                user.setEmail("john@example.com");
                user.setPassword("password123");

                usersDAO.insertUser(user);

                System.out.println("User inserted successfully");

                // 获取所有用户
                List<Users> usersList = usersDAO.getAllUsers();
                for (Users u : usersList) {
                    System.out.println("User ID: " + u.getId() + ", Name: " + u.getName());
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



