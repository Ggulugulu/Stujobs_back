package com.example.stujobs.service;


import com.example.stujobs.mapper.PingJiaMapper;
import com.example.stujobs.pojo.PingJia;
import com.example.stujobs.pojo.PingJiaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PingJiaService {
    @Autowired
    private PingJiaMapper mapper;

    //查找评价 根据具体的某个岗位
    public List<PingJia> showlikesByJobId(int jobId) {
        PingJiaExample example = new PingJiaExample();
        PingJiaExample.Criteria criteria = example.createCriteria();
        criteria.andJobsIdEqualTo(jobId);
        return  mapper.selectByExample(example);
    }

    //添加评价
    public void addlike(PingJia like) {
        mapper.insert(like);
    }
}
