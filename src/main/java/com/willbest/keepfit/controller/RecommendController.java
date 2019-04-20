package com.willbest.keepfit.controller;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.service.RecommendService;
import com.willbest.keepfit.utilandpojo.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/rec")
public class RecommendController {
    @Autowired
    RecommendService recommendService;
    @RequestMapping(value = "/sturec")
    public List<course> recommend(HttpServletRequest request){

        return Tool.listToolTodb_list(recommendService.recommend(request));
    }
}
