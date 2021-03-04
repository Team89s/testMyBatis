package com.igeek.entity;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Description OrdersCustom 订单拓展类
 * @Author chenmin
 * @Date 2021/3/4 9:07
 */
public class OrdersCustom extends Orders{

    //resultType方式
    /*private String username;
    private String sex;
    private Date birthday;
    private String address;

    public OrdersCustom() {
    }

    public OrdersCustom(String username, String sex, Date birthday, String address) {
        this.username = username;
        this.sex = sex;
        this.birthday = birthday;
        this.address = address;
    }

    *//**
     * 获取
     * @return username
     *//*
    public String getUsername() {
        return username;
    }

    *//**
     * 设置
     * @param username
     *//*
    public void setUsername(String username) {
        this.username = username;
    }

    *//**
     * 获取
     * @return sex
     *//*
    public String getSex() {
        return sex;
    }

    *//**
     * 设置
     * @param sex
     *//*
    public void setSex(String sex) {
        this.sex = sex;
    }

    *//**
     * 获取
     * @return birthday
     *//*
    public Date getBirthday() {
        return birthday;
    }

    *//**
     * 设置
     * @param birthday
     *//*
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    *//**
     * 获取
     * @return address
     *//*
    public String getAddress() {
        return address;
    }

    *//**
     * 设置
     * @param address
     *//*
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "OrdersCustom{username = " + username + ", sex = " + sex + ", birthday = " + birthday + ", address = " + address + "}"
                +super.toString();
    }*/

    //resultMap方式   一对一关联用户
    private UserCustom userCustom;
    //一对多关联 订单明细
    private List<OrderdetailCustom> orderdetailCustomList;


    public OrdersCustom() {
    }

    public OrdersCustom(UserCustom userCustom, List<OrderdetailCustom> orderdetailCustomList) {
        this.userCustom = userCustom;
        this.orderdetailCustomList = orderdetailCustomList;
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
     * @return orderdetailCustomList
     */
    public List<OrderdetailCustom> getOrderdetailCustomList() {
        return orderdetailCustomList;
    }

    /**
     * 设置
     * @param orderdetailCustomList
     */
    public void setOrderdetailCustomList(List<OrderdetailCustom> orderdetailCustomList) {
        this.orderdetailCustomList = orderdetailCustomList;
    }

    public String toString() {
        return super.toString();
    }
}
