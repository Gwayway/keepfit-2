package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.comment;
import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.mapper.CommentMapper;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.StudentMapper;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CommentService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CommentMapper commentMapper;
    public restful comment(comment comment, HttpServletRequest request){
        course course=courseMapper.findCourseById(comment.getCourseid());
        student student=studentMapper.findByPhonenum((String) request.getSession().getAttribute("phonenum"));
        comment.setOwnnerphonenum((String) request.getSession().getAttribute("phonenum"));
        comment.setContentownner(student.getUsername());
        comment.setStudent(student);
        comment.setCourse(course);
        commentMapper.save(comment);
        return new restful("succe",null,"com");
    }
}
