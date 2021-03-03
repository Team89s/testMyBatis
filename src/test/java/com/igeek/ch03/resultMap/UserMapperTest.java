package com.igeek.ch03.resultMap;

import com.igeek.entity.UserCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom = userMapper.findUserById(10);
        System.out.println(userCustom);

        sqlSession.close();
    }
}