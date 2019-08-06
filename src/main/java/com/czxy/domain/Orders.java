package com.czxy.domain;


import javax.persistence.Id;
import java.util.List;

public class Orders {
    @Id
    private String oid;
    private String statu;
    private String time;
    private String address;
    private String phone;
    private String uid;
    private String picture;
    private List<Orderitem> orderitems;

    public Orders() {
    }

    public Orders(String oid, String statu, String time, String address, String phone, String uid, String picture, List<Orderitem> orderitems) {
        this.oid = oid;
        this.statu = statu;
        this.time = time;
        this.address = address;
        this.phone = phone;
        this.uid = uid;
        this.picture = picture;
        this.orderitems = orderitems;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }


    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(List<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", statu='" + statu + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", uid='" + uid + '\'' +
                ", picture='" + picture + '\'' +
                ", orderitems=" + orderitems +
                '}';
    }
}
