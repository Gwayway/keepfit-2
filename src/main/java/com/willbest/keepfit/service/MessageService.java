package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.message;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.MessageMapper;
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
    public chatmsg deal(chatmsg chatmsg){
        course course=courseMapper.findCourseById(chatmsg.getCourseid());
        student student=studentMapper.findByPhonenum(chatmsg.getGetphonenum());
        message message=messageMapper.findByCourseidAndAndStudentphonenum(chatmsg.getCourseid(),chatmsg.getSendphonenum());
        switch (chatmsg.getDealstate()){
            case "acc":{
                message.setDealsate("acc");
                messageMapper.save(message);
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
}
