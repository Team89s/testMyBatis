package com.igeek.entity;

import java.util.List;

/**
 * @version 1.0
 * @Description UserQueryVO 包装类型，封装上综合查询条件
 * @Author chenmin
 * @Date 2021/3/3 10:35
 */
public class UserQueryVO {

    private UserCustom userCustom;
    //通过一组id查询用户信息
    private List<Integer> ids;

    public UserQueryVO() {
    }

    public UserQueryVO(UserCustom userCustom, List<Integer> ids) {
        this.userCustom = userCustom;
        this.ids = ids;
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

    /**
     * 获取
     * @return ids
     */
    public List<Integer> getIds() {
        return ids;
    }

    /**
     * 设置
     * @param ids
     */
    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String toString() {
        return "UserQueryVO{userCustom = " + userCustom + ", ids = " + ids + "}";
    }


    //private OrdersCustom ordersCustom;
    //private ItemsCustom itemsCustom;


}
