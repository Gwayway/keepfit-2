package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.teacher;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.TeacherMapper;
import com.willbest.keepfit.utilandpojo.restful;
import org.neo4j.ogm.model.Node;
import org.neo4j.ogm.response.model.NodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    public restful releasecourse(course course, teacher teacher){

        NodeModel node=new NodeModel(teacherMapper.findByPhonenum(teacher.getPhonenum()).getId());
        course.setNode(node);
        courseMapper.save(course);
        return  new restful("200",course,"k");
    }
}
