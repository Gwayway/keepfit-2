package com.willbest.keepfit.mapper;
import com.willbest.keepfit.bean.student;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
public interface StudentMapper extends Neo4jRepository<student,Long> {
    @Query("match(Student:student) where Student.phonenum={phonenum} return Student")
    student findByPhonenum(@Param("phonenum") String phonenum);
}
