package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.message;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.MessageMapper;
import com.willbest.keepfit.utilandpojo.PageList;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
public class ListService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    MessageMapper messageMapper;
    public  restful list(HttpServletRequest request, PageList pagelist){//course全部，stucourse学生的课，teccourse老师课，
        String type=pagelist.getType();
        Pageable pageable = PageRequest.of(pagelist.getCurrentPage(),pagelist.getPageSize(),new Sort(Sort.Direction.ASC,"id"));
        if (type!=null){
            switch (type){
                case "course":{
                    Page<course> courses=courseMapper.findAll(pageable);
                    return  new restful("succes",courses.getContent(),"courselist");
                }break;
                case "stucourse":{
                    Page<course> courses=courseMapper.findcoursesByStudentPhonenum((String) request.getSession().getAttribute("phonenum"),pageable);
                    return new restful("succes",courses.getContent(),"stucourselist");
                }break;
                case "tescourse":{
                    Page<course> courses=courseMapper.findcoursesByTeacherPhonenum((String) request.getSession().getAttribute("phonenum"),pageable);
                    return new restful("succes",courses.getContent(),"teccoprselist");
                }break;
                case "stumessage":{
                    Page<message> messages=messageMapper.findmessagesByStudentPhonenum((String) request.getSession().getAttribute("phonenum"),pageable);
                    return new restful("succes",messages.getContent(),"stumessagelist");
                }break;
                case "tecmessage":{
                    Page<message> messages=messageMapper.findmessagesByTeacherPhonenum((String) request.getSession().getAttribute("phonenum"),pageable);
                }break;
            }
        }else {
            return new restful("typeerro",null,"listerro")
        }
    }
}
