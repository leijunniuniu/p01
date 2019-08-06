package com.czxy.dao;

import com.czxy.domain.PCD;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PCDMapper extends Mapper<PCD> {
    @Select("select * from pcd where pid=0")
    public List<PCD> findAllProvince();

    @Select("select * from pcd where pid=#{id}")
    public List<PCD> findById(String id);
}
