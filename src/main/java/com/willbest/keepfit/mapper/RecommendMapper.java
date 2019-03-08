package com.willbest.keepfit.mapper;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import java.util.Set;

public interface RecommendMapper extends Neo4jRepository {
    @Query("match (Student:student)-[Order:order]->(Course:course) where Student.phonenum={phonenum} return Course")
    Set<course> getAllcourseByStu(String phonenum);
    @Query("match (Student:student)-[Order:order]->(Course:course) where Course.courseid={courseid} return Student")
    Set<student> getAllStuByCourse(Long courseid);
}
