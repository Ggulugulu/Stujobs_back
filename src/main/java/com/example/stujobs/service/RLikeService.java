package com.example.stujobs.service;

import com.example.stujobs.mapper.IntroduceMapper;
import com.example.stujobs.mapper.R_LikeMapper;
import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.pojo.relation.R_Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RLikeService {
    @Autowired
    private R_LikeMapper mapper;

    public List<Jobs> showByUserId(Integer userId) {
        return  mapper.showByUserId(userId);
    }

    public void add(R_Like pojo) {
        mapper.insert(pojo);
    }
}
