package com.willbest.keepfit.controller;

import com.willbest.keepfit.utilandpojo.chatmsg;
import com.willbest.keepfit.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;
    @MessageMapping("/deal/{getphonenum}")
    @SendTo("/topic/deal/{getphonenum}")
    public chatmsg deal(String senphonenum,String getphonenum,Long courseid,String dealstate){
        chatmsg chatmsg=new chatmsg(courseid,senphonenum,getphonenum,dealstate);
        return  messageService.deal(chatmsg);
    }

    @MessageMapping("/order/{getphonenum}")
    @SendTo("/topic/order/{getphonenum}")
    //处理order,发送消息到到教练订阅地址
    public chatmsg  order(String senphonenum,String getphonenum,Long courseid,String dealstate){
        chatmsg chatmsg=new chatmsg(courseid,senphonenum,getphonenum,dealstate);
        return chatmsg;
    }
}
