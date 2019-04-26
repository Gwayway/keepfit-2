package com.willbest.keepfit.mapper;
import com.willbest.keepfit.bean.Order_relationship;
import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseMapper extends Neo4jRepository <course,Long>{
    @Query("match (Course:course) where id(Course)={id} return Course")
    course findCourseById(@Param("id") Long id);
    @Query(value = "match (Student:student)-[Order:order]->(Course:course) where Student.phonenum={phonenum} return Course",countQuery ="match (Student:student)-[Order:order]->(Course:course) where Student.phonenum={phonenum} return count(*)")
    Page<course> findcoursesByStudentPhonenum(@Param("phonenum") String phonenum, Pageable pageable);
    @Query(value = "match (Teacher:teacher)-[Release:release]->(Course:course) where Teacher.phonenum={phonenum} return Course",countQuery = "match (Teacher:teacher)-[Release:release]->(Course:course) where Teacher.phonenum={phonenum} return count(*)")
    Page<course> findcoursesByTeacherPhonenum(@Param("phonenum") String phonenum,Pageable pageable);
    @Query(value = "match(Course:course) return Course",countQuery = "match(Course:course) return count(*)")
    Page<course> findAll(Pageable pageable);
    @Query(value = "match(Student:student)-[Like:like]->(Course:course) where Student.phonenum={phonenum} return Course",countQuery = "match(Student:student)-[Like:like]->(Course:course) where Student.phonenum={phonenum} return count(*)")
    Page<course> findlovecoursesByPhonenum(@Param("phonenum") String phonenum,Pageable pageable);
    @Query(value = "match(Course:course) where Course.tagNum={tagNum} return Course",countQuery = "match(Course:course) where Course.tagNum={tagNum} return count(*)")
    Page<course> findcoursesBytype(@Param("tagNum") Integer tagNum,Pageable pageable);
    @Query("match(Student:student)-[Order:order]->(Course:course) where Student.phonenum={phonenum} AND id(Course)={courseid} return Order")
    Order_relationship findRelation_stu_cour(@Param("phonenum") String phonenum,@Param("courseid") Integer courseid);
    @Query("match(Student:student)-[Order:order]->(Course:course) where Student.phonenum={phonenum} AND id(Course)={courseid} DELETE Order")
    void findRelation_stu_cour2(@Param("phonenum") String phonenum,@Param("courseid") Integer courseid);
    @Query("match(Course:course) where id(Course)={courseid} DETACH DELETE Course")
    void  deletecourseByCourseid(@Param("courseid") Integer courseid);
}
