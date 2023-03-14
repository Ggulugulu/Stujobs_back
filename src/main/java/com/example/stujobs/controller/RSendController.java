package com.example.stujobs.controller;


import com.example.stujobs.Msg;
import com.example.stujobs.pojo.Introduce;
import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.pojo.R_Send;
import com.example.stujobs.service.RLikeService;
import com.example.stujobs.service.RSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.ObjIntConsumer;


@RestController
@RequestMapping("/send")
public class RSendController {
    @Autowired
    private RSendService service;

    //checked 显示用户投递的岗位列表
    @GetMapping("/sendList")
    @ResponseBody
    public List<Map<String,Object>> showByUserId(@RequestParam(value = "sendId") Integer sendId) {
        return service.showByUserId(sendId);
    }

    //checked 显示hr接受的用户信息
    @GetMapping("/toList")
    @ResponseBody
    public List<Map<String,Object>> showByHrId(@RequestParam(value = "toId") Integer toId) {
        return service.showByHrId(toId);
    }

    @PostMapping("/addSend")
    @ResponseBody
    public Msg addSend(@RequestBody R_Send pojo) {
        service.add(pojo);
        return Msg.success();
    }

    //checked 更新结果
    @PostMapping("/updateResult")
    @ResponseBody
    public Msg updateResult(@RequestBody Map<String,String> pojo) {
        service.updateResult(pojo);
        return Msg.success();
    }

}
