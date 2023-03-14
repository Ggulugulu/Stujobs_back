package com.example.stujobs.service;

import com.example.stujobs.mapper.IntroduceMapper;
import com.example.stujobs.pojo.Introduce;
import com.example.stujobs.pojo.IntroduceExample;
import com.example.stujobs.pojo.JobsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntroduceService {
    @Autowired
    private IntroduceMapper mapper;

    public void add(Introduce pojo) {
        mapper.insert(pojo);
    }

    public List<Introduce> showByUserId(Integer userId) {
        IntroduceExample example = new IntroduceExample();
        IntroduceExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return  mapper.selectByExample(example);
    }
}
