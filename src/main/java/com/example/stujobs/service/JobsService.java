package com.example.stujobs.service;

import com.example.stujobs.mapper.JobsMapper;
import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.pojo.JobsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService {
    @Autowired
    private JobsMapper mapper;
    public List<Jobs> showJobsList(){
        JobsExample example = new JobsExample();
        return  mapper.selectByExampleWithBLOBs(example);
    }

    //查找job 根据标签
    public List<Jobs> showJobsListByTags(String tags){
        JobsExample example = new JobsExample();
        JobsExample.Criteria criteria = example.createCriteria();
        criteria.andTagsLike("%"+tags+"%");
       // System.out.println(example);
        return  mapper.selectByExampleWithBLOBs(example);
    }

    //查找job 根据主键
    public Jobs showJobById(int id) {
        return  mapper.selectByPrimaryKey(id);
    }
}
