package com.example.stujobs.service;

import com.example.stujobs.mapper.JobsMapper;
import com.example.stujobs.mapper.MessageMapper;
import com.example.stujobs.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper mapper;


    public List<Message> getMessagesBetweenUsers(int senderId, int receiverId) {
        return mapper.getMessagesBetweenUsers(senderId, receiverId);
    }

    public void sendMessage(Message pojo) {
        mapper.insert(pojo);
    }
}
