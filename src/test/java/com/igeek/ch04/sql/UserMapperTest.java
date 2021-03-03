package com.igeek.ch04.sql;

import com.igeek.entity.UserCustom;
import com.igeek.entity.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findUserByPojo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom = new UserCustom();
        //综合查询条件
        userCustom.setSex("1");
        userCustom.setUsername("明");

        UserQueryVO vo = new UserQueryVO();
        vo.setUserCustom(userCustom);

        List<UserCustom> userCustomList = userMapper.findUserByPojo(vo);
        for (UserCustom custom : userCustomList) {
            System.out.println(custom);
        }

        sqlSession.close();
    }

    @Test
    public void findCountsByPojo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom = new UserCustom();
        //综合查询条件
        userCustom.setSex("1");
        userCustom.setUsername("明");

        UserQueryVO vo = new UserQueryVO();
        vo.setUserCustom(userCustom);

        int counts = userMapper.findCountsByPojo(vo);
        System.out.println("总记录数："+counts);

        sqlSession.close();
    }

    @Test
    public void findUserByPojoAndId() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom = new UserCustom();
        //综合查询条件
        userCustom.setSex("1");
        userCustom.setUsername("明");
        //一组id
        List<Integer> ids = Stream.of(10, 16, 22).collect(Collectors.toList());
        /*List<Integer> ids = new ArrayList<>();
        ids.add(10);
        ids.add(16);
        ids.add(22);*/

        UserQueryVO vo = new UserQueryVO();
        vo.setUserCustom(userCustom);
        vo.setIds(ids);

        List<UserCustom> userCustomList = userMapper.findUserByPojoAndId(vo);
        for (UserCustom custom : userCustomList) {
            System.out.println(custom);
        }

        sqlSession.close();
    }
}