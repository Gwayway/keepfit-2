package com.willbest.keepfit.controller;

import com.willbest.keepfit.service.MessageService;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MessageController_2 {
    @Autowired
    MessageService messageService;
    @RequestMapping("/order")
    public List orderCourse(){
        return null;
    }
    @RequestMapping("/deal")
    public String dealMsg(Long msgid,String dealsate){
        System.out.println(msgid);
        return messageService.deal_2(msgid,dealsate);
    }
}
