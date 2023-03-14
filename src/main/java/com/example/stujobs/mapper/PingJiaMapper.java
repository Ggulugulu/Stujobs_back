package com.example.stujobs.mapper;

import com.example.stujobs.pojo.PingJia;
import com.example.stujobs.pojo.PingJiaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PingJiaMapper {
    long countByExample(PingJiaExample example);

    int deleteByExample(PingJiaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PingJia record);

    int insertSelective(PingJia record);

    List<PingJia> selectByExample(PingJiaExample example);

    PingJia selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PingJia record, @Param("example") PingJiaExample example);

    int updateByExample(@Param("record") PingJia record, @Param("example") PingJiaExample example);

    int updateByPrimaryKeySelective(PingJia record);

    int updateByPrimaryKey(PingJia record);
}