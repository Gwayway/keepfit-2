package com.willbest.keepfit.controller;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.message;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.bean.teacher;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.service.CourseService;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cc")
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping("/ac")
    public restful addcourse(String coursename,String courseownner,String introduce,String phonenum,String ...picurls){
        //多图处理
        List picurl=new ArrayList();
        for(String i:picurls){
            picurl.add(i);
        }
        teacher teacher=new teacher(courseownner,null,null,phonenum);
        course course=new course(null,coursename,picurl,teacher.getUsername(),introduce,null);
        return  courseService.releasecourse(course,teacher);
    }
    @RequestMapping("/o")
    public restful ordercourse(String studentphonenum,Long courseid,String studentname,String teschername,String coursename){
        student student=new student(null,null,null,studentphonenum);
        course course=new course(courseid,null,null,null,null,null);
        message message=new message(courseid,teschername,studentname,coursename,studentphonenum,null,null);
        return courseService.ordercourse(course,message,student);

    }
}
