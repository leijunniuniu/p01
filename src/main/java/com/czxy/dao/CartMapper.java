package com.czxy.dao;

import com.czxy.domain.Cart;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CartMapper extends Mapper<Cart> {
    @Select("select * from cart where uid=#{uid}")
    @Results({
            @Result(property = "cartId",column = "cart_id"),
            @Result(property = "cartitems",many = @Many(select = "com.CartitemMapper.findCartitemByCartId"),column = "cart_id")
    })
    public List<Cart> findAllCartByUid(String uid);

    @Select("select * from cart where cart_id=#{cartId}")
    @Results({
            @Result(property = "cartId",column = "cart_id"),
            @Result(property = "cartitems",many = @Many(select = "com.CartitemMapper.findCartitemByCartId"),column = "cart_id")
    })
    public Cart findCartById(String cartId);
}
