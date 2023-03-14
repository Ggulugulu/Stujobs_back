package com.example.stujobs.controller;

import com.example.stujobs.Msg;
import com.example.stujobs.pojo.Introduce;
import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.pojo.relation.R_Like;
import com.example.stujobs.service.IntroduceService;
import com.example.stujobs.service.RLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class RLikeController {
    @Autowired
    private RLikeService service;

    //checked 显示用户的喜欢列表
    @GetMapping("/list")
    @ResponseBody
    public List<Jobs> showByUserId(@RequestParam(value = "userId") Integer userId) {
        return service.showByUserId(userId);
    }

    //checked 添加用户喜欢
    @PostMapping("/add")
    @ResponseBody
    public Msg add(@RequestBody R_Like pojo) {
        service.add(pojo);
        return Msg.success();
    }
}
