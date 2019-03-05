package com.willbest.keepfit.controller;

import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.bean.teacher;
import com.willbest.keepfit.service.UserService;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cis")
public class MainController {
    @Autowired
    UserService userService;
    @RequestMapping("/c1")
    public restful createstudent(String username, String password, String nickname, String phonenum){
        student student=new student(username,password,nickname,phonenum);
        return userService.createstudent(student);
    }
    @RequestMapping("l1")
    public restful loginstudent(String phonenum,String password){
        student student=new student(null,password,null,phonenum);
        return userService.login1(student);
    }
    @RequestMapping("c2")
    public restful createteacher(String username, String password, String nickname, String phonenum){
        teacher teacher=new teacher(username,nickname,password,phonenum);
        return  userService.createteacher(teacher);
    }
    @RequestMapping("l2")
    public restful loginteachaer(String phonenum,String password){
        teacher teacher=new teacher(null,null,password,phonenum);
        return userService.login2(teacher);
    }
}