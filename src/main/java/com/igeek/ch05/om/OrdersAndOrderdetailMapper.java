package com.igeek.ch05.om;

import com.igeek.entity.OrdersCustom;

import java.util.List;

public interface OrdersAndOrderdetailMapper {

    public List<OrdersCustom> findOrders();

}
