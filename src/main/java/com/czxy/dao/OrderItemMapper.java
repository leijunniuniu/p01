package com.czxy.dao;

import com.czxy.domain.Orderitem;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderItemMapper extends Mapper<Orderitem> {
    @Select("select * from orderitem where oid=#{oid}")
    @Results({
            @Result(property = "pid",column = "pid"),
            @Result(property = "product",one = @One(select = "com.ProductMapper.selectByPrimaryKey"),column = "pid")
    })
    public List<Orderitem> findOrderitemByOid(String oid);

    @Select("select * from orderitem where oiid=#{oiid}")
    @Results({
            @Result(property = "pid",column = "pid"),
            @Result(property = "product",one = @One(select = "com.ProductMapper.selectByPrimaryKey"),column = "pid")
    })
    public Orderitem findOrderitemByOiid(String oiid);
}
