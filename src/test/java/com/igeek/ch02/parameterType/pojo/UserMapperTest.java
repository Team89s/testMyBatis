package com.igeek.ch02.parameterType.pojo;

import com.igeek.entity.UserCustom;
import com.igeek.entity.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

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
    public void findUserByHashMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //此时HashMap中的key必须与Mapper.xml映射文件中的#{key}一致；一旦不一致，则值为null
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("gender","1");
        hashMap.put("name","明");  //测试不一致的情况name123，则姓名映射不进去，为null

        List<UserCustom> userCustomList = userMapper.findUserByHashMap(hashMap);
        System.out.println(userCustomList.size());

        sqlSession.close();
    }
}