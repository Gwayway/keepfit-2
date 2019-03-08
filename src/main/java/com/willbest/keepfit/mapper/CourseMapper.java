package com.willbest.keepfit.mapper;
import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.bean.student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface CourseMapper extends Neo4jRepository <course,Long>{
    @Query("match (Course:course) where id(Course)={id} return Course")
    course findCourseById(@Param("id") Long id);
    @Query("create ({student})-[Order:order]->({course})")//可能会出错!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    void createRelationOrder(@Param("student") student student,@Param("course") course course);
}
