package com.igeek.ch03.resultType.simple;

import com.igeek.entity.UserCustom;
import com.igeek.entity.UserQueryVO;
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
    public void findCountsByPojo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("明");
        userCustom.setSex("1");

        UserQueryVO vo = new UserQueryVO();
        vo.setUserCustom(userCustom);

        int counts = userMapper.findCountsByPojo(vo);
        System.out.println("总记录数："+counts);

        sqlSession.close();
    }
}