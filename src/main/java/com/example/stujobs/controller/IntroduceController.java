package com.example.stujobs.controller;

import com.example.stujobs.Msg;
import com.example.stujobs.pojo.Introduce;
import com.example.stujobs.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/introduce")
public class IntroduceController {
    @Autowired
    private IntroduceService service;

    //checked 显示用户的简历列表
    @GetMapping("/list")
    @ResponseBody
    public List<Introduce> showByUserId(@RequestParam(value = "userId") Integer userId) {
        return service.showByUserId(userId);
    }

    //checked 添加用户简历
    @PostMapping("/add")
    @ResponseBody
    public Msg add(@RequestBody Introduce pojo) {
        service.add(pojo);
        return Msg.success();
    }
}
