package com.igeek.entity;

/**
 * @version 1.0
 * @Description OrderdetailCustom 作为Orderdetail订单明细的拓展类
 * @Author chenmin
 * @Date 2021/3/4 10:15
 */
public class OrderdetailCustom extends Orderdetail {

    //一对一关联 商品信息
    private ItemsCustom itemsCustom;


    public OrderdetailCustom() {
    }

    public OrderdetailCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    /**
     * 获取
     * @return itemsCustom
     */
    public ItemsCustom getItemsCustom() {
        return itemsCustom;
    }

    /**
     * 设置
     * @param itemsCustom
     */
    public void setItemsCustom(ItemsCustom itemsCustom) {
        this.itemsCustom = itemsCustom;
    }

    public String toString() {
        return super.toString();
    }
}
