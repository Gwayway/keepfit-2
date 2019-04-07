package com.willbest.keepfit.service;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.student;
import com.willbest.keepfit.mapper.CommentMapper;
import com.willbest.keepfit.mapper.CourseMapper;
import com.willbest.keepfit.mapper.RecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecommendService {
    @Autowired
    RecommendMapper recommendMapper;
    @Autowired
    CourseMapper courseMapper;
    public List<course> recommend(HttpServletRequest request){
        String phonenum=(String) request.getSession().getAttribute("phonenum");
        Set<course> courseSet=recommendMapper.getAllcourseByStu(phonenum);
        int size=courseSet.size();
        if(size==0){
            return recommend2(request);
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
            courseSet1.removeAll(courseSet);
            int len=courseSet1.size();
            List<course> courseList=new ArrayList<>(courseSet1);
            if (len<5||len==5){
                return courseList;
            }else {
                List<course> recomList=new ArrayList<>();
                for (int i=0;i<5;i++){
                    int index=new Double(Math.random()*len).intValue();
                    recomList.add(courseList.get(index));
                }
                courseSet1=new HashSet<>(recomList);
                recomList=new ArrayList<>(courseSet1);
                return  recomList;
            }
        }
    }
    private   List<course> recommend2(HttpServletRequest request){
        String phonenum=(String) request.getSession().getAttribute("phonenum");
        List<course> courses= (List) courseMapper.findAll();
        List<course> courselist=new ArrayList<>();
        int len=courses.size();
        for (int i=0;i<5;i++){
            courselist.add(courses.get(new Double(Math.random()*len).intValue()));
        }
        return courselist;
    }
}
