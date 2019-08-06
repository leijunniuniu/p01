package com.czxy.service;

import com.czxy.domain.Product;

import java.util.List;

public interface ProductService {

    //模糊查询
    public List<Product> findProducts(String pname);

    //通过名字查找该商品
    public Product findByNametoInfo(String pname);


    //通过商品 id 查找商品

    public Product findById(String pid);

//    通过商品的cid 查询
    public List<Product> findAllProduct(String cid);


    //上一层
    public List<Product> upProducts(String cid);


    //下一层
    public List<Product> dowmProducts(String cid);

    /**
     * 查询所有cid为1，2的手机前6条
     *
     * @return
     */
    public List<Product> findProductByCid();

    /**
     * 查询所有cid为1，2的手机后6条
     *
     * @return
     */
    public List<Product> findProductByCid01();


    /**
     * 查询电视
     */
    public List<Product> findTvByCid();


    /**
     * 查询电视
     */
    public List<Product> findTvByCid01();

    /**
     * 查询笔记本
     */
    public List<Product>findPcByCid();

    /**
     * 查询笔记本
     */
    public List<Product>findPcByCid01();


    /**
     * 查询家电
     */
    public List<Product>findFurnitureByCid();

    /**
     * 查询家电
     */
    public List<Product>findFurnitureByCid01();

    /**
     * 查询路由器
     */
    public List<Product>findRouterByCid();


    /**
     * 查询路由器
     */
    public List<Product>findRouterByCid01();


    /**
     * 查询配件
     */
    public List<Product>findPartByCid();


    /**
     * 查询配件
     */
    public List<Product>findPartByCid01();

    /**
     * 健康儿童
     */
    public List<Product>findChildByCid();

    /**
     * 耳机音响
     */
    public List<Product>findHeadsetByCid();


    /**
     * 生活箱包
     */
    public List<Product>findBoxByCid();
}
