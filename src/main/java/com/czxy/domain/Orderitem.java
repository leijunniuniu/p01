package com.czxy.domain;


import javax.persistence.Id;

public class Orderitem {
    @Id
    private String oiid;
    private Integer num;
    private Integer subprice;
    private String pid;
    private String type;
    private String oid;
    private Product product;

    public Orderitem() {
    }

    public Orderitem(String oiid, Integer num, Integer subprice, String pid, String type, String oid, Product product) {
        this.oiid = oiid;
        this.num = num;
        this.subprice = subprice;
        this.pid = pid;
        this.type = type;
        this.oid = oid;
        this.product = product;
    }

    public String getOiid() {
        return oiid;
    }

    public void setOiid(String oiid) {
        this.oiid = oiid;
    }


    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSubprice() {
        return subprice;
    }

    public void setSubprice(Integer subprice) {
        this.subprice = subprice;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Orderitem{" +
                "oiid='" + oiid + '\'' +
                ", num=" + num +
                ", subprice=" + subprice +
                ", pid='" + pid + '\'' +
                ", type='" + type + '\'' +
                ", oid='" + oid + '\'' +
                ", product=" + product +
                '}';
    }
}
