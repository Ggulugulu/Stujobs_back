package com.example.stujobs.controller;

import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService service;

    //checked 显示首页工作列表 或 同类tag工作列表
    @GetMapping("/list")
    @ResponseBody
    public List<Jobs> showJobsListByTags(@RequestParam(value = "tags" , required = false) String tags) {
        if (tags !=null){
            return service.showJobsListByTags(tags);
        }else{
            return service.showJobsList();
        }
    }

    //checked 显示某个岗位的详情页面
    @GetMapping("/list/detail")
    @ResponseBody
    public Jobs showJobById(@RequestParam(value = "id") int id) {
        return  service.showJobById(id);
    }
}
