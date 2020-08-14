package com.lanxin.util;

import com.lanxin.dao.RoleDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


public class MySqlSession {

    public static SqlSession getSqlSession() throws IOException {
        SqlSessionFactoryBuilder sessionFactoryBuilder=new SqlSessionFactoryBuilder();
        return sessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml")).openSession();
    }

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = getSqlSession();
        RoleDao mapper = sqlSession.getMapper(RoleDao.class);
        mapper.selectPassByName("tom");
    }

}
