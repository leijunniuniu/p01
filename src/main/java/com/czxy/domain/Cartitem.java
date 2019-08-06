package com.czxy.domain;


import javax.persistence.Id;

public class Cartitem {
    @Id
    private String cartitem_id;
    private Integer subprice;
    private Integer num;
    private String cartId;
    private String type;
    private String pid;
    private Product product;

    public Cartitem() {
    }

    public Cartitem(String cartitem_id, Integer subprice, Integer num, String cartId, String type, String pid, Product product) {
        this.cartitem_id = cartitem_id;
        this.subprice = subprice;
        this.num = num;
        this.cartId = cartId;
        this.type = type;
        this.pid = pid;
        this.product = product;
    }

    public String getCartitem_id() {
        return cartitem_id;
    }

    public void setCartitem_id(String cartitem_id) {
        this.cartitem_id = cartitem_id;
    }

    public Integer getSubprice() {
        return subprice;
    }

    public void setSubprice(Integer subprice) {
        this.subprice = subprice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cartitem{" +
                "cartitem_id='" + cartitem_id + '\'' +
                ", subprice=" + subprice +
                ", num=" + num +
                ", cartId='" + cartId + '\'' +
                ", type='" + type + '\'' +
                ", pid='" + pid + '\'' +
                ", product=" + product +
                '}';
    }
}
