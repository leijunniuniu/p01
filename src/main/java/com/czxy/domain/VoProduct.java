package com.czxy.domain;

import java.util.List;

public class VoProduct {

    List<Product> upProducts;

    List<Product> dowmProducts;

    public List<Product> getUpProducts() {
        return upProducts;
    }

    public void setUpProducts(List<Product> upProducts) {
        this.upProducts = upProducts;
    }

    public List<Product> getDowmProducts() {
        return dowmProducts;
    }

    public void setDowmProducts(List<Product> dowmProducts) {
        this.dowmProducts = dowmProducts;
    }

    public VoProduct() {
    }

    public VoProduct(List<Product> upProducts, List<Product> dowmProducts) {
        this.upProducts = upProducts;
        this.dowmProducts = dowmProducts;
    }

    @Override
    public String toString() {
        return "VoProduct{" +
                "upProducts=" + upProducts +
                ", dowmProducts=" + dowmProducts +
                '}';
    }
}
