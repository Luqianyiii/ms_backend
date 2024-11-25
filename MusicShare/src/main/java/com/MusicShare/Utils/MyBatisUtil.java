package com.MusicShare.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

    public class MyBatisUtil {
        private static SqlSessionFactory sqlSessionFactory;

        static {
            try {
                // 加载 MyBatis 配置文件
                Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Error initializing SqlSessionFactory.", e);
            }
        }

        // 获取 SqlSession 对象
        public static SqlSession getSqlSession() {
            return sqlSessionFactory.openSession(); // 默认手动提交事务
        }
    }


