package com.willbest.keepfit.controller;

import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rec")
public class RecommendController {
    @RequestMapping(value = "/sturec",method = RequestMethod.POST)
    public restful recommend(String phonenum){

    }
}
