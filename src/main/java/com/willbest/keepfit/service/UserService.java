package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.bean.teacher;
import com.willbest.keepfit.mapper.StudentMapper;
import com.willbest.keepfit.mapper.TeacherMapper;
import com.willbest.keepfit.utilandpojo.existif;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService<T>{
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    existif existif;
    public restful createstudent(student student){
        String phonenum=student.getPhonenum();
        boolean state=existif.exist(phonenum);
        if (state){
            return new restful("exist",null,"s");
        }else {
            studentMapper.save(student);
            return  new restful("createsucce",student.getPhonenum()+":"+student.getUsername(),"s");
        }
    }
    public restful login1(student student){
        String phonenum=student.getPhonenum();
        boolean state=existif.exist(phonenum);
        student neostu= studentMapper.findByPhonenum(phonenum);
        if (state){
            if (student.getPassword().equals(neostu.getPassword())){
                return  new restful("loginsucce",student.getPhonenum()+":"+neostu.getUsername(),"s");
            }else {
                return  new restful("passworserro",null,"s");
            }
        }else {
            return new restful("notexist",null,"s");
        }
    }
    public restful createteacher(teacher teacher){
        String phonenum=teacher.getPhonenum();
        boolean state=existif.exist(phonenum);
        if (state){
            return new restful("exist",null,"t");
        }else {
            teacherMapper.save(teacher);
            return  new restful("createsucce",teacher.getPhonenum()+":"+teacher.getUsername(),"t");
        }
    }
    public restful login2(teacher teacher){
        String phonenum=teacher.getPhonenum();
        boolean state=existif.exist(phonenum);
        teacher neostec= teacherMapper.findByPhonenum(phonenum);
        if (state){
            if (teacher.getPassword().equals(neostec.getPassword())){
                return  new restful("loginsucce",teacher.getPhonenum()+":"+neostec.getUsername(),"t");
            }else {
                return  new restful("passworserro",null,"t");
            }
        }else {
            return new restful("notexist",null,"t");
        }
    }
}
