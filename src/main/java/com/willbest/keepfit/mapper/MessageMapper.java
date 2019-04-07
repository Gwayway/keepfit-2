package com.willbest.keepfit.mapper;
import com.willbest.keepfit.bean.message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface MessageMapper extends Neo4jRepository<message,Long> {
    @Query("match (Message:message) where Message.courseid={courseid}AND Message.studentphone={studentphonenum} return Message")
    message findByCourseidAndAndStudentphonenum( Long courseid, String studentphonenum);
    @Query(value = "match (Teacher:teacher)-[Get:get]->(Message:message) where Teacher.phonenum={phonenum}AND Message.dealsate='nul' return Message ",countQuery ="match (Teacher:teacher)-[Get:get]->(Message:message) where Teacher.phonenum={phonenum}AND Message.dealsate='null' return count(*)" )
    Page<message> findmessagesByTeacherPhonenum(@Param("phonenum") String phonenum, Pageable pageable);
    @Query(value = "match (Student:student)-[Send:send]->(Message:message) where Student.phonenum={phonenum}AND Message.dealsate<>'nul' return Message",countQuery ="match (Student:student)-[Send:send]->(Message:message) where Student.phonenum={phonenum}AND Message.dealsate<>'null' return count(*)" )
    Page<message> findmessagesByStudentPhonenum(@Param("phonenum") String phonenum, Pageable pageable);
}
