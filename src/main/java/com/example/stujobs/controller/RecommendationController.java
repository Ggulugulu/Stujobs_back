package com.example.stujobs.controller;

import com.example.stujobs.pojo.Jobs;
import com.example.stujobs.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/recommend")
    public List<Jobs> recommendJobs(@RequestParam(value = "userId") int userId) {
        return recommendationService.recommendJobs(userId);
    }

}
