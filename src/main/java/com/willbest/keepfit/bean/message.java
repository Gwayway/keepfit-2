package com.willbest.keepfit.bean;

import com.willbest.keepfit.utilandpojo.date;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@NodeEntity(label = "message")
@Data
public class message {
    @Id
    @GeneratedValue
    private  Long id;
    private Long courseid;
    private String getname;
    private String sendname;
    private  String coursename;
    private String studentphonenum;
    private String teacherphonenum;//后来添加
    private  String dates=new date().getDate();
    private  String dealsate="nul";//"nul"未处理"rej"拒绝"acc"接受

    @Relationship(type = "send",direction = Relationship.INCOMING)
    private student student;
    @Relationship(type = "get",direction = Relationship.INCOMING)
    private teacher teacher;

    public message(Long courseid, String getname, String sendname, String coursename, String studentphonenum, com.willbest.keepfit.bean.student student, com.willbest.keepfit.bean.teacher teacher) {
        this.courseid = courseid;
        this.getname = getname;
        this.sendname = sendname;
        this.coursename = coursename;
        this.studentphonenum = studentphonenum;
        this.student = student;
        this.teacher = teacher;
    }
}
