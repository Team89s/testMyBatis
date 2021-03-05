package com.igeek.ch07.ehcache;

import com.igeek.entity.UserCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    //会在每一次执行测试方法之前，都必执行
    @Before
    public void setUp() throws Exception {
        //1.加载MyBatis的核心配置文件
        InputStream inputStream =
                Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建会话工厂对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserCustom user1 = mapper.findUserById(10);
        System.out.println(user1);

        UserCustom user2 = mapper.findUserById(10);
        System.out.println(user2);
    }
}