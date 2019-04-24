package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.comment;
import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.message;
import com.willbest.keepfit.mapper.CommentMapper;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.MessageMapper;
import com.willbest.keepfit.utilandpojo.PageList;
import com.willbest.keepfit.utilandpojo.Tool;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ListService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    CommentMapper commentMapper;
    public  restful list(HttpServletRequest request, PageList pagelist){//course全部，stucourse学生的课，teccourse老师课，
        String type=pagelist.getType();
        Pageable pageable =PageRequest.of(pagelist.getCurrentPage(),pagelist.getPageSize());
        if (type!=null) {
            switch (type) {
                case "course": {
                    Page<course> courses = courseMapper.findAll(pageable);
                    return new  restful("succes", courses.getContent(), "courselist");
                }
                case "stucourse": {
                    Page<course> courses = courseMapper.findcoursesByStudentPhonenum((String) request.getSession().getAttribute("phonenum"), pageable);
                    return new restful("succes", courses.getContent(), "stucourselist");
                }
                case "teccourse": {
                    Page<course> courses = courseMapper.findcoursesByTeacherPhonenum((String) request.getSession().getAttribute("phonenum"),pageable);
                    return new restful("succes", courses.getContent(), "teccoprselist");
                }
                case "stumessage": {
                    Page<message> messages = messageMapper.findmessagesByStudentPhonenum((String) request.getSession().getAttribute("phonenum"), pageable);
                    return new restful("succes", messages.getContent(), "stumessagelist");
                }
                case "tecmessage": {
                    Page<message> messages = messageMapper.findmessagesByTeacherPhonenum((String) request.getSession().getAttribute("phonenum"), pageable);
                    return new restful("succes", messages.getContent(), "tecmessagelist");
                }
                case "comment": {
                    Page<comment> comments = commentMapper.findByCourseid(pagelist.getDepent(), pageable);
                    return new restful("succes", comments.getContent(), "commentslist");
                }
            }
            return new restful("erro", null, "listerro");
        }else{
            return new restful("typeerro", null, "listerro");
        }
    }
    public List double_list(HttpServletRequest request,PageList pageList){
        Pageable pageable =PageRequest.of(pageList.getCurrentPage(),pageList.getPageSize());
        Page<course> courses = courseMapper.findAll(pageable);
        List corseList=courses.getContent();
        return corseList;
    }
    public List like_list(HttpServletRequest request,PageList pageList){
        Pageable pageable=PageRequest.of(pageList.getCurrentPage(),pageList.getPageSize());
        Page<course> courses=courseMapper.findlovecoursesByPhonenum((String) request.getSession().getAttribute("phonenum"),pageable);
        return courses.getContent();
    }

    public  List taglist(HttpServletRequest request,PageList pageList,Integer tagNum){
        Pageable pageable =PageRequest.of(pageList.getCurrentPage(),pageList.getPageSize());
        switch (tagNum){
            case 0:{
                return like_list(request,pageList);
            }
            case 1:{
                Page<course> courses = courseMapper.findcoursesByStudentPhonenum((String) request.getSession().getAttribute("phonenum"),pageable);
                return courses.getContent();
            }
            case 2:{
                Page<message> messages = messageMapper.findmessagesByStudentPhonenum((String) request.getSession().getAttribute("phonenum"), pageable);
                return messages.getContent();
            }
            case 3:{
                Page<course> courses=courseMapper.findcoursesBytype(tagNum,pageable);
                return  courses.getContent();
            }
            case 4:{
                Page<course> courses=courseMapper.findcoursesBytype(tagNum,pageable);
                return  courses.getContent();
            }
            case 5:{
                Page<course> courses=courseMapper.findcoursesBytype(tagNum,pageable);
                return  courses.getContent();
            }
            case 6:{
                Page<course> courses=courseMapper.findcoursesBytype(tagNum,pageable);
                return  courses.getContent();
            }
            case 7:{
                Page<course> courses=courseMapper.findcoursesBytype(tagNum,pageable);
                return  courses.getContent();
            }
            case 8:{
                Page<course> courses=courseMapper.findcoursesBytype(tagNum,pageable);
                return  courses.getContent();
            }
            case 9:{
                Page<course> courses=courseMapper.findcoursesBytype(tagNum,pageable);
                return  courses.getContent();
            }
        }
        return null;
    }

}
