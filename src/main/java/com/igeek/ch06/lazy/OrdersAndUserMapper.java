package com.igeek.ch06.lazy;

import com.igeek.entity.OrdersCustom;
import com.igeek.entity.User;

import java.util.List;

public interface OrdersAndUserMapper {

    //查询所有订单
    public List<OrdersCustom> findOrdersByLazy();

    //根据订单所属者id，查询用户信息
    public User findUserById(int id);

}
