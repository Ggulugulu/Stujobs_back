package com.example.stujobs.mapper;

import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.pojo.relation.R_Like;
import com.example.stujobs.pojo.relation.R_LikeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface R_LikeMapper {
    long countByExample(R_LikeExample example);

    int deleteByExample(R_LikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(R_Like record);

    int insertSelective(R_Like record);

    List<R_Like> selectByExample(R_LikeExample example);

    R_Like selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") R_Like record, @Param("example") R_LikeExample example);

    int updateByExample(@Param("record") R_Like record, @Param("example") R_LikeExample example);

    int updateByPrimaryKeySelective(R_Like record);

    int updateByPrimaryKey(R_Like record);

    List<Jobs> showByUserId(@Param("userId")Integer userId);
    @MapKey("id")
    List<Map<String, Object>> selectJoinJobs();

    String selectTagsByJobId(@Param("jobId")Integer jobId);
}