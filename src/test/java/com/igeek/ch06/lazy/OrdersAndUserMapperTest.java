package com.igeek.ch06.lazy;

import com.igeek.entity.OrdersCustom;
import com.igeek.entity.UserCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersAndUserMapperTest {

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
    public void findOrdersByLazy() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersAndUserMapper mapper = sqlSession.getMapper(OrdersAndUserMapper.class);
        List<OrdersCustom> ordersCustomList = mapper.findOrdersByLazy();
        for (OrdersCustom ordersCustom : ordersCustomList) {
            //测试一：测试是否只查询出所有订单信息
            System.out.println(ordersCustom);

            //测试二：测试是否按需加载
            UserCustom userCustom = ordersCustom.getUserCustom();
            System.out.println(userCustom);
        }
        sqlSession.close();
    }
}