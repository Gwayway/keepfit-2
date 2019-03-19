package com.willbest.keepfit.controller;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.message;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.bean.teacher;
import com.willbest.keepfit.service.CourseService;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cc")
public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping("/ac")
    public restful addcourse(String coursename, String introduce, HttpServletRequest request,String ...picurls ){
        //多图处理
        List picurl=new ArrayList();
        for(String i:picurls){
            picurl.add(i);
        }
        teacher teacher=new teacher(null,null,null,(String) request.getSession().getAttribute("phonenum"));
        course course=new course(null,coursename,picurl,null,introduce,null);
        return  courseService.releasecourse(course,teacher);
    }
    @RequestMapping("/o")
    public restful ordercourse(HttpServletRequest request,Long courseid,String teschername,String coursename){
        student student=new student(null,null,null,(String) request.getSession().getAttribute("phonenum"));
        course course=new course(courseid,null,null,null,null,null);
        message message=new message(courseid,teschername,null,coursename,null,null,null);
        return courseService.ordercourse(course,message,student);

    }
}
