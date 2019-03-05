package com.willbest.keepfit.utilandpojo;

import com.willbest.keepfit.mapper.StudentMapper;
import com.willbest.keepfit.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class existif {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    public  boolean exist(String phonenum){
        if((studentMapper.findByPhonenum(phonenum)!=null)||(teacherMapper.findByPhonenum(phonenum)!=null))
        {
            return  true;
        }else {
            return false;
        }
    }
}
