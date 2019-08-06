package com.czxy.domain;

public class VoBuyBow {
    private Product product;
    private Integer num;
    private String type;
    private Integer subprice;

    public VoBuyBow() {
    }

    public VoBuyBow(Product product, Integer num, String type, Integer subprice) {
        this.product = product;
        this.num = num;
        this.type = type;
        this.subprice = subprice;
    }

    public Integer getSubprice() {
        return subprice;
    }

    public void setSubprice(Integer subprice) {
        this.subprice = subprice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VoBuyBow{" +
                "product=" + product +
                ", num=" + num +
                ", type='" + type + '\'' +
                ", subprice=" + subprice +
                '}';
    }
}
