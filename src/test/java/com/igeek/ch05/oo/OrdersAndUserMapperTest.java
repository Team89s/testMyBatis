package com.igeek.ch05.oo;

import com.igeek.entity.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrdersAndUserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findOrdersAndUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersAndUserMapper mapper = sqlSession.getMapper(OrdersAndUserMapper.class);
        List<OrdersCustom> ordersList = mapper.findOrdersAndUser();
        for (OrdersCustom ordersCustom : ordersList) {
            System.out.println(ordersCustom);
        }
        sqlSession.close();
    }

    @Test
    public void findOrdersAndUserMap(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersAndUserMapper mapper = sqlSession.getMapper(OrdersAndUserMapper.class);
        List<OrdersCustom> ordersList = mapper.findOrdersAndUserMap();
        for (OrdersCustom ordersCustom : ordersList) {
            System.out.println(ordersCustom);
        }
        sqlSession.close();
    }
}