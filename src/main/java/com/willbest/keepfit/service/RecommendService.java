package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.mapper.RecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecommendService {
    @Autowired
    RecommendMapper recommendMapper;
    public Set<course> recommend(String phonenum){
        Set<course> courseSet=recommendMapper.getAllcourseByStu(phonenum);
        int size=courseSet.size();
        if(size==0){

        }else {
            Set<student> studentSet1=new HashSet<>();
            Set<course>  courseSet1=new HashSet<>();
            for(course course:courseSet){
                Set<student> students=recommendMapper.getAllStuByCourse(course.getId());
                for (student student:students){
                    studentSet1.add(student);
                }
            }
            for (student student:studentSet1){
                Set<course> courses=recommendMapper.getAllcourseByStu(student.getPhonenum());
                for (course course:courses){
                    courseSet1.add(course);
                }
            }
            Set<course> result=new HashSet<>();
            result.clear();
            result.addAll(courseSet1);
            result.removeAll(courseSet);
            courseSet=result;
        }
    }
}
