package com.willbest.keepfit.controller;

import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.bean.teacher;
import com.willbest.keepfit.service.UserService;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/cis",method = RequestMethod.POST)
public class MainController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/c1",method = RequestMethod.POST)
    public restful createstudent(String username, String password, String nickname, String phonenum){
        student student=new student(username,password,nickname,phonenum);
        return userService.createstudent(student);
    }
    @RequestMapping(value = "l1",method = RequestMethod.POST)
    public restful loginstudent(String phonenum, String password, HttpServletRequest request, HttpSession session){
        System.out.println(session.getId());
        student student=new student(null,password,null,phonenum);
        return userService.login1(student,request,session);
    }
    @RequestMapping("c2")
    public restful createteacher(String username, String password, String nickname, String phonenum){
        teacher teacher=new teacher(username,nickname,password,phonenum);
        return  userService.createteacher(teacher);
    }
    @RequestMapping("l2")
    public restful loginteachaer(String phonenum,String password,HttpServletRequest request,HttpSession session){
        System.out.println(request);
        teacher teacher=new teacher(null,null,password,phonenum);
        return userService.login2(teacher,request,session);
    }
}