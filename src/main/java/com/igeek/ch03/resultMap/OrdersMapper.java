package com.igeek.ch03.resultMap;

import com.igeek.entity.Orders;

import java.util.List;

public interface OrdersMapper {

    public List<Orders> findOrders();

}
