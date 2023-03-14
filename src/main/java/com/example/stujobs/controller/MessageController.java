package com.example.stujobs.controller;

import com.example.stujobs.Msg;
import com.example.stujobs.pojo.Message;
import com.example.stujobs.service.JobsService;
import com.example.stujobs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService service;


    //checked 获取消息内容
    @GetMapping("/{senderId}/{receiverId}")
    public List<Message> getMessagesBetweenUsers(@PathVariable int senderId, @PathVariable int receiverId) {
        return service.getMessagesBetweenUsers(senderId, receiverId);
    }
    //checked 发送消息
    @PostMapping("/send")
    public Msg sendMessage(@RequestBody Message message) {
        service.sendMessage(message);
        return Msg.success();
    }
}
