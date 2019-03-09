package com.willbest.keepfit.controller;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rec")
public class RecommendController {
    @Autowired
    RecommendService recommendService;
    @RequestMapping(value = "/sturec",method = RequestMethod.POST)
    public List<course> recommend(String phonenum){
        return recommendService.recommend(phonenum);
    }
}
