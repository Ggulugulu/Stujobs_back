package com.example.stujobs.mapper;

import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.pojo.JobsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface JobsMapper {
    long countByExample(JobsExample example);

    int deleteByExample(JobsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jobs record);

    int insertSelective(Jobs record);

    List<Jobs> selectByExampleWithBLOBs(JobsExample example);

    List<Jobs> selectByExample(JobsExample example);

    Jobs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jobs record, @Param("example") JobsExample example);

    int updateByExampleWithBLOBs(@Param("record") Jobs record, @Param("example") JobsExample example);

    int updateByExample(@Param("record") Jobs record, @Param("example") JobsExample example);

    int updateByPrimaryKeySelective(Jobs record);

    int updateByPrimaryKeyWithBLOBs(Jobs record);

    int updateByPrimaryKey(Jobs record);
}