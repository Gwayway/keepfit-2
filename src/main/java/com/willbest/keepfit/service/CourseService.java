package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.*;
import com.willbest.keepfit.mapper.*;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    RelationshipMapper  relationshipMapper;
    //教师发布课程
    public restful releasecourse(course course, teacher teacher){
            teacher neotec=teacherMapper.findByPhonenum(teacher.getPhonenum());
            course.setCourseownner(neotec.getUsername());
            course.setTeacher(neotec);
        switch (course.getCourse_type()){
            case "运动":{
                course.setTagNum(3);
            }break;
            case "跑步":{
                course.setTagNum(4);
            }break;
            case "瑜伽":{
                course.setTagNum(5);
            }break;
            case "跑酷":{
                course.setTagNum(6);
            }break;
            case "举重":{
                course.setTagNum(7);
            }break;
            case "游泳":{
                course.setTagNum(8);
            }break;
            case "其他":{
                course.setTagNum(9);
            }
        }
            courseMapper.save(course);
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
        message.setTeacherphonenum(neotec.getPhonenum());
        messageMapper.save(message);
        return new restful("succe",null,"m");
    }
    //获取课程详细
    public restful getcourse(Long courseid){
        return  new restful("succe",courseMapper.findCourseById(courseid),"course");
    }
    //收藏课程
    public String course_like(Long course_id, HttpServletRequest request){
        String phone_num=(String) request.getSession().getAttribute("phonenum");
        course course_neo=courseMapper.findCourseById(course_id);
        student student_neo=studentMapper.findByPhonenum(phone_num);
        course_neo.setStart_count(course_neo.getStart_count()+1);
        Like_relationship likeRelationship=new Like_relationship(null,student_neo,course_neo);
        try{
            courseMapper.save(course_neo);
            relationshipMapper.save(likeRelationship);
        }catch (Exception e){
            return "err";
        }
        return "like:ok";
    }
    //取消预约
    public  void  cancel_oder(String phonenum,Integer courseid){
        Order_relationship relation_stu_cour=courseMapper.findRelation_stu_cour(phonenum,courseid);
        relation_stu_cour.setLife(0);
        relationshipMapper.save(relation_stu_cour);
    }
    public void  cancel_order2(String phonenum,Integer courseid){
        courseMapper.findRelation_stu_cour2(phonenum,courseid);
    }
    //删除课程
    public String cancelCourse(Integer couserid){
        courseMapper.deletecourseByCourseid(couserid);
        return "deltok";
    }
    //更改课程信息
    public  String setCourse(Long courseid,String coursename,String introduce, List<String> picurls){
        course course_neo=courseMapper.findCourseById(courseid);
        course_neo.setCoursename(coursename);
        course_neo.setPicurl(picurls);
        course_neo.setIntroduce(introduce);
        courseMapper.save(course_neo);
        return "okset";
    }
}
