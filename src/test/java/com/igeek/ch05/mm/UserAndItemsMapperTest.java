package com.igeek.ch05.mm;

import com.igeek.entity.ItemsCustom;
import com.igeek.entity.OrderdetailCustom;
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

public class UserAndItemsMapperTest {

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
    public void findUserAndItems() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserAndItemsMapper mapper = sqlSession.getMapper(UserAndItemsMapper.class);
        List<UserCustom> list = mapper.findUserAndItems();
        for (UserCustom userCustom : list) {
            System.out.println("================用户信息====================");
            System.out.println("用户信息："+userCustom.toString());

            List<OrdersCustom> ordersList = userCustom.getOrdersList();
            for (OrdersCustom ordersCustom : ordersList) {
                System.out.println("================订单信息====================");
                System.out.println("订单信息："+ordersCustom);

                List<OrderdetailCustom> orderdetailCustomList = ordersCustom.getOrderdetailCustomList();

                for (OrderdetailCustom orderdetailCustom : orderdetailCustomList) {
                    System.out.println("================订单明细信息====================");
                    System.out.println("订单明细："+orderdetailCustom);

                    System.out.println("================商品信息====================");
                    ItemsCustom itemsCustom = orderdetailCustom.getItemsCustom();
                    System.out.println("商品信息："+itemsCustom);
                }
            }
        }
        sqlSession.close();
    }
}