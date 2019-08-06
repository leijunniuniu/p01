package com.czxy.dao;

import com.czxy.domain.Cartitem;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CartitemMapper extends Mapper<Cartitem> {
    @Select("select * from cartitem")
    @Results({
            @Result(property = "cartitem_id",column = "cartitem_id"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "product",one = @One(select = "com.ProductMapper.selectByPrimaryKey"),column = "pid")
    })
    public List<Cartitem> findAllCartitem();

    @Select("SELECT * FROM cartitem WHERE cartitem_id=#{cartitem_id}")
    @Results({
            @Result(property = "cartitem_id",column = "cartitem_id"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "product",one = @One(select = "com.ProductMapper.selectByPrimaryKey"),column = "pid")
    })
    public Cartitem findCartitemById(@Param("cartitem_id") String cartitem_id);

    @Select("select * from cartitem where cart_id=#{cart_id}")
    @Results({
            @Result(property = "cartitem_id",column = "cartitem_id"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "product",one = @One(select = "com.ProductMapper.selectByPrimaryKey"),column = "pid")
    })
    public List<Cartitem> findCartitemByCartId(@Param("cart_id") String cart_id);
}
