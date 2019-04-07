package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.message;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.bean.teacher;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.MessageMapper;
import com.willbest.keepfit.mapper.StudentMapper;
import com.willbest.keepfit.mapper.TeacherMapper;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    MessageMapper messageMapper;
    //教师发布课程
    public restful releasecourse(course course, teacher teacher){
        try{
            teacher neotec=teacherMapper.findByPhonenum(teacher.getPhonenum());
            course.setCourseownner(neotec.getUsername());
            course.setTeacher(neotec);
            courseMapper.save(course);
        }catch (Exception e){
            System.out.println(e);
            return new restful("courseadderro",null,"k");
        }
        return  new restful("succe",teacher.getPhonenum(),"k");
    }
    //学生预约课程
    public restful ordercourse(course course, message message,student student){
        teacher neotec=teacherMapper.findTecByCourseId(course.getId());
        student neostu=studentMapper.findByPhonenum(student.getPhonenum());
        message.setStudentphonenum(neostu.getPhonenum());
        message.setSendname(neostu.getUsername());
        message.setStudent(neostu);
        message.setTeacher(neotec);
        messageMapper.save(message);
        return new restful("succe",null,"m");
    }
    //获取课程详细
    public restful getcourse(Long courseid){
        return  new restful("succe",courseMapper.findCourseById(courseid),"course");
    }
}
