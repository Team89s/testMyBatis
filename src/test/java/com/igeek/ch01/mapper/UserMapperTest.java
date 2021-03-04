package com.igeek.ch01.mapper;

import com.igeek.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public void selectOneById() {
        //1.获得SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3.执行
        User user = userMapper.selectOneById(10);
        System.out.println("user = "+user);
        //4.关闭资源
        sqlSession.close();
    }

    @Test
    public void selectListByLikeName(){
        //1.获得SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3.执行
        List<User> userList = userMapper.selectListByLikeName("明");

        /*
            select * from user where username like '%${value}%'
            拼接后，发生SQL注入：
            select * from user where username like '%' or 1=1 or '%'
         */
        //List<User> userList = userMapper.selectListByLikeName("' or 1=1 or '");

        for (User user : userList) {
            System.out.println(user);
        }
        //4.关闭资源
        sqlSession.close();
    }


    @Test
    public void insertUser() throws ParseException {
        //1.获得SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //2.获得代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //3.执行
        User user = new User();
        user.setUsername("海绵宝宝");
        user.setSex("2");
        user.setAddress("江苏无锡");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2021-03-01";
        Date birthday = sdf.parse(str);
        user.setBirthday(birthday);

        userMapper.insertUser(user);
        System.out.println("user = "+user);

        //4.提交事务
        sqlSession.commit();
        //5.关闭资源
        sqlSession.close();
    }













}