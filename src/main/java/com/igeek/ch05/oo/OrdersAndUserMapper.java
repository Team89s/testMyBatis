package com.igeek.ch05.oo;

import com.igeek.entity.OrdersCustom;

import java.util.List;

public interface OrdersAndUserMapper {

    //resultType
    public List<OrdersCustom> findOrdersAndUser();

    //resultMap
    public List<OrdersCustom> findOrdersAndUserMap();
}
