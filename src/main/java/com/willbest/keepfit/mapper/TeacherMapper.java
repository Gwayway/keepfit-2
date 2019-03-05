package com.willbest.keepfit.mapper;

import com.willbest.keepfit.bean.teacher;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface TeacherMapper extends Neo4jRepository<teacher,Long> {
    @Query("match(Teacher:teacher) where Teacher.phonenum={phonenum} return Teacher")
    teacher findByPhonenum(@Param("phonenum") String phonenum);
}
