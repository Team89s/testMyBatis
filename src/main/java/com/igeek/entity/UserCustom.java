package com.igeek.entity;

import java.util.List;

/**
 * @version 1.0
 * @Description UserCustom 是User的拓展类
 * @Author chenmin
 * @Date 2021/3/3 10:33
 */
public class UserCustom extends User {

    //一对多关联 订单信息
    private List<OrdersCustom> ordersList;

    public UserCustom() {
    }

    public UserCustom(List<OrdersCustom> ordersList) {
        this.ordersList = ordersList;
    }

    /**
     * 获取
     * @return ordersList
     */
    public List<OrdersCustom> getOrdersList() {
        return ordersList;
    }

    /**
     * 设置
     * @param ordersList
     */
    public void setOrdersList(List<OrdersCustom> ordersList) {
        this.ordersList = ordersList;
    }

    public String toString() {
        return super.toString();
    }
}
