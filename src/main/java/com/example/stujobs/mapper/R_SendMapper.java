package com.example.stujobs.mapper;

import com.example.stujobs.pojo.R_Send;
import com.example.stujobs.pojo.R_SendExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface R_SendMapper {
    long countByExample(R_SendExample example);

    int deleteByExample(R_SendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(R_Send record);

    int insertSelective(R_Send record);

    List<R_Send> selectByExample(R_SendExample example);

    R_Send selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") R_Send record, @Param("example") R_SendExample example);

    int updateByExample(@Param("record") R_Send record, @Param("example") R_SendExample example);

    int updateByPrimaryKeySelective(R_Send record);

    int updateByPrimaryKey(R_Send record);
    @MapKey("id")
    List<Map<String,Object>> showByUserId(@Param("sendId")Integer sendId);
    @MapKey("id")
    List<Map<String,Object>> showByHrId(@Param("toId")Integer toId);

}