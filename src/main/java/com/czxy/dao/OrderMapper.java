package com.czxy.dao;

import com.czxy.domain.Orders;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderMapper extends Mapper<Orders> {
    @Select("select * from orders where uid=#{uid}")
    @Results({
            @Result(property = "oid",column = "oid"),
            @Result(property = "orderitems",many = @Many(select = "com.OrderItemMapper.findOrderitemByOid"),column = "oid")
    })
    public List<Orders> findOrdersByUid(String uid);
}
