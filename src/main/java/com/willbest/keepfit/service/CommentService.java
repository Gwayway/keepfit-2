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

@Service
public class CommentService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CommentMapper commentMapper;
    public restful comment(comment comment){
        course course=courseMapper.findCourseById(comment.getCourseid());
        student student=studentMapper.findByPhonenum(comment.getOwnnerphonenum());
        comment.setStudent(student);
        comment.setCourse(course);
        commentMapper.save(comment);
        return new restful("succe",null,"com");
    }
}
