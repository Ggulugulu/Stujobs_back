package com.example.stujobs.controller;

import com.example.stujobs.Msg;
import com.example.stujobs.pojo.PingJia;
import com.example.stujobs.service.PingJiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pingjia")
public class PingJiaController {
    @Autowired
    private PingJiaService service;

    //checked  添加评价
    @PostMapping("/add")
    @ResponseBody
    public Msg addlike(@RequestBody PingJia like) {
        service.addlike(like);
        return Msg.success();
    }

    //checked  显示岗位详情页底下的评价列表
    @GetMapping("/list/detail")
    @ResponseBody
    public List<PingJia> showlikesByJobId(@RequestParam(value = "jobId") int jobId) {
        return  service.showlikesByJobId(jobId);
    }
}
