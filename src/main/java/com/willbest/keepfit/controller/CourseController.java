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
    public restful addcourse(String coursename, String introduce, HttpServletRequest request,String[] picurls,String tag){
        //多图处理
        List picurl=new ArrayList();
        for(String i:picurls){
            picurl.add(i);
        }
        teacher teacher=new teacher(null,null,null,(String) request.getSession().getAttribute("phonenum"));
        course course=new course(null,coursename,picurl,null,introduce,null,(String) request.getSession().getAttribute("phonenum"),tag);
        return  courseService.releasecourse(course,teacher);
    }
    @RequestMapping("/o")
    public restful ordercourse(HttpServletRequest request,Long courseid,String teschername,String coursename){
        student student=new student(null,null,null,(String) request.getSession().getAttribute("phonenum"));
        course course=new course(courseid,null,null,null,null,null,null,null);
        message message=new message(courseid,teschername,null,coursename,null,null,null);
        return courseService.ordercourse(course,message,student);

    }
    @RequestMapping("/gc")
    public restful getcourse(Long courseid){
        return  courseService.getcourse(courseid);
    }
    @RequestMapping("/like")
    public  String course_like(Long course_id,HttpServletRequest request){
        return courseService.course_like(course_id,request);
    }
    @RequestMapping("/canlo")
    public  void cancel_order(String phonenum,Integer courseid){
        courseService.cancel_order2(phonenum,courseid);
    }
    @RequestMapping("/set")
    public  String  setCourse(Long courseid,String coursename,String introduce, String[] picurls){
        List picurl=new ArrayList();
        for(String i:picurls){
            picurl.add(i);
        }
        return courseService.setCourse(courseid,coursename,introduce,picurl);

    }
    @RequestMapping("/canlcourse")
    public String cancelCourse(Integer courseid){
        return courseService.cancelCourse(courseid);
    }
}
