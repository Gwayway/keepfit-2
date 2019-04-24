package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.Order_relationship;
import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.message;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.MessageMapper;
import com.willbest.keepfit.mapper.RelationshipMapper;
import com.willbest.keepfit.mapper.StudentMapper;
import com.willbest.keepfit.utilandpojo.chatmsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    public chatmsg deal(chatmsg chatmsg){
        course course=courseMapper.findCourseById(chatmsg.getCourseid());
        student student=studentMapper.findByPhonenum(chatmsg.getGetphonenum());
        message message=messageMapper.findByCourseidAndAndStudentphonenum(chatmsg.getCourseid(),chatmsg.getSendphonenum());
        switch (chatmsg.getDealstate()){
            case "acc":{
                message.setDealsate("acc");
                messageMapper.save(message);
                relationshipMapper.save(new Order_relationship(student,course));
                chatmsg.setDealstate("acc");
                return chatmsg;
            }
            case "rej":{
                message.setDealsate("rej");
                messageMapper.save(message);
                chatmsg.setDealstate("rej");
                return  chatmsg;
            }
        }
        return chatmsg;
    }
    public String deal_2(Long msgid,String dealstate){
        message message=messageMapper.findBymsgId(msgid);
        System.out.println(message.getStudentphonenum());
        student student=studentMapper.findByPhonenum(message.getStudentphonenum());
        course course=courseMapper.findCourseById(message.getCourseid());
        message.setDealsate(dealstate);
        messageMapper.save(message);
        if(dealstate.equals("acc")){
            relationshipMapper.save(new Order_relationship(student,course));
        }
        return  "msgdeal";
    }
}
