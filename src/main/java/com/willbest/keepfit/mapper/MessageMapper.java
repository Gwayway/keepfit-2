package com.willbest.keepfit.mapper;
import com.willbest.keepfit.bean.message;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MessageMapper extends Neo4jRepository<message,Long> {
    @Query("match (Message:message) where Message.courseid={courseid}AND Message.studentphone={studentphonenum} return Message")
    message findByCourseidAndAndStudentphonenum( Long courseid, String studentphonenum);

}
