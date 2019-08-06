package com.czxy.dao;

import com.czxy.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ProductMapper extends Mapper<Product> {
    //模糊查询
    @Select("SELECT * FROM protect WHERE pname LIKE #{pname} LIMIT 0,6")
    public List<Product> ByNamefindProduct(@Param("pname") String pname);

    //上一层 SELECT * FROM protect WHERE cid=1 LIMIT 0,5

    @Select("SELECT * FROM protect WHERE cid=#{cid} LIMIT 0,6")
    public List<Product> upProduct(@Param("cid") String cid);


    //下一层  SELECT * FROM protect WHERE cid=1 LIMIT 5,5
    @Select("SELECT * FROM protect WHERE cid=#{cid} LIMIT 5,5")
    public List<Product> downProduct(@Param("cid") String cid);

    /**
     * 查询所有cid为1，2的手机前6条
     */
    @Select("select * from protect where cid =1 limit 0,6")
    public List<Product> findProductByCid();


    /**
     * 查询所有cid为1，2的手机后6条
     */
    @Select("select * from protect where cid =1 limit 6,6")
    public List<Product> findProductByCid01();


    /**
     * 查询电视
     */
    @Select("select * from protect where cid =3 limit 0,6")
    public List<Product> findTvByCid();

    /**
     * 查询电视
     */
    @Select("select * from protect where cid =3 limit 6,6")
    public List<Product> findTvByCid01();


    /**
     * 查询笔记本
     */
    @Select("select * from protect where cid =4 limit 0,6")
    public List<Product>findPcByCid();

    /**
     * 查询笔记本
     */
    @Select("select * from protect where cid =4 limit 6,6")
    public List<Product>findPcByCid01();

    /**
     * 查询家电
     */
    @Select("select * from protect where cid =5 limit 0,6")
    public List<Product>findFurnitureByCid();

    /**
     * 查询家电
     */
    @Select("select * from protect where cid =5 limit 6,6")
    public List<Product>findFurnitureByCid01();


    /**
     * 查询路由器
     */
    @Select("select * from protect where cid =6 limit 0,6")
    public List<Product>findRouterByCid();


    /**
     * 查询路由器
     */
    @Select("select * from protect where cid =8 limit 6,6")
    public List<Product>findRouterByCid01();

    /**
     * 查询配件
     */
    @Select("select * from protect where cid =8 limit 0,6")
    public List<Product>findPartByCid();


    /**
     * 查询配件
     */
    @Select("select * from protect where cid =8 limit 6,6")
    public List<Product>findPartByCid01();


    /**
     * 健康儿童
     */
    @Select("select * from protect where cid =9 limit 0,6")
    public List<Product>findChildByCid();

    /**
     * 耳机音响
     */
    @Select("select * from protect where cid =10 limit 0,6")
    public List<Product>findHeadsetByCid();


    /**
     * 生活箱包
     */
    @Select("select * from protect where cid =11 limit 0,6")
    public List<Product>findBoxByCid();

}
