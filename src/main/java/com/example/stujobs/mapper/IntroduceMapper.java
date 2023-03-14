package com.example.stujobs.mapper;

import com.example.stujobs.pojo.Introduce;
import com.example.stujobs.pojo.IntroduceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface IntroduceMapper {
    long countByExample(IntroduceExample example);

    int deleteByExample(IntroduceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Introduce record);

    int insertSelective(Introduce record);

    List<Introduce> selectByExample(IntroduceExample example);

    Introduce selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Introduce record, @Param("example") IntroduceExample example);

    int updateByExample(@Param("record") Introduce record, @Param("example") IntroduceExample example);

    int updateByPrimaryKeySelective(Introduce record);

    int updateByPrimaryKey(Introduce record);
}