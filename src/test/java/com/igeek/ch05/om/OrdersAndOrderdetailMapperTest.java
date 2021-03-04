package com.igeek.ch05.om;

import com.igeek.entity.OrderdetailCustom;
import com.igeek.entity.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersAndOrderdetailMapperTest {

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
    public void findOrders() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersAndOrderdetailMapper mapper = sqlSession.getMapper(OrdersAndOrderdetailMapper.class);
        List<OrdersCustom> orders = mapper.findOrders();
        for (OrdersCustom order : orders) {
            System.out.println(order);
        }
        sqlSession.close();
    }
}