package com.igeek.ch07.cache2;

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
        /**
         * 在同一个namespace下，无论创建多少个SqlSession会话对象，共享二级缓存
         *
         * 关闭资源，清空一级缓存，将数据从一级缓存空间迁移至二级缓存空间
         */
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();

        //在sqlSession1中，发起第一次查询
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserCustom user1 = userMapper1.findUserById(10);
        System.out.println("user1 = "+user1);
        //关闭资源，清空一级缓存，并将数据写到二级缓存区域
        sqlSession1.close();

        //增删改
        /*UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        user1.setUsername("lisisi");
        userMapper3.updateUser(user1);
        //提交事务，清空缓存
        sqlSession3.commit();
        //关闭资源
        sqlSession3.close();*/

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //在sqlSession2中，发起第二次查询
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserCustom user2 = userMapper2.findUserById(10);
        System.out.println("user2 = "+user2);
        //关闭资源
        sqlSession2.close();
    }
}