package com.czxy.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name ="protect")
public class Product {

    @Id
    private String pid;

    private String pname;

    private String pinfo;

    private String picture;

    private Integer price;

    private String pversions;

    private String pcolor;

    private String cid;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPversions() {
        return pversions;
    }

    public void setPversions(String pversions) {
        this.pversions = pversions;
    }

    public String getPcolor() {
        return pcolor;
    }

    public void setPcolor(String pcolor) {
        this.pcolor = pcolor;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Product() {
    }

    public Product(String pid, String pname, String pinfo, String picture, Integer price, String pversions, String pcolor, String cid) {
        this.pid = pid;
        this.pname = pname;
        this.pinfo = pinfo;
        this.picture = picture;
        this.price = price;
        this.pversions = pversions;
        this.pcolor = pcolor;
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", pinfo='" + pinfo + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                ", pversions='" + pversions + '\'' +
                ", pcolor='" + pcolor + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
