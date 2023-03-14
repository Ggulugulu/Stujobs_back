package com.example.stujobs.service;

import com.example.stujobs.mapper.R_SendMapper;
import com.example.stujobs.pojo.R_Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RSendService {
    @Autowired
    private R_SendMapper mapper;

    public List<Map<String,Object>> showByUserId(Integer sendId) {
        return mapper.showByUserId(sendId);
    }

    public List<Map<String,Object>> showByHrId(Integer toId) {
        return mapper.showByHrId(toId);
    }

    public void add(R_Send pojo) {
        mapper.insert(pojo);
    }

    public void updateResult(Map<String,String> pojo) {
        R_Send send = new R_Send();
        send.setId(Integer.parseInt(pojo.get("id")));
        send.setResult(pojo.get("result"));
        mapper.updateByPrimaryKeySelective(send);
    }
}
