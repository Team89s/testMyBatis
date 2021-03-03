package com.igeek.entity;

/**
 * @version 1.0
 * @Description UserQueryVO 包装类型，封装上综合查询条件
 * @Author chenmin
 * @Date 2021/3/3 10:35
 */
public class UserQueryVO {

    private UserCustom userCustom;

    public UserQueryVO() {
    }

    public UserQueryVO(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    /**
     * 获取
     * @return userCustom
     */
    public UserCustom getUserCustom() {
        return userCustom;
    }

    /**
     * 设置
     * @param userCustom
     */
    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public String toString() {
        return "UserQueryVO{userCustom = " + userCustom + "}";
    }

    //private OrdersCustom ordersCustom;
    //private ItemsCustom itemsCustom;


}
