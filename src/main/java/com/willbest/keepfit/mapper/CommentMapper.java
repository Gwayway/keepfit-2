package com.willbest.keepfit.mapper;

import com.willbest.keepfit.bean.comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface CommentMapper extends Neo4jRepository<comment,Long> {
    @Query(value = "match(Comment:comment) where Comment.courseid={courseid} return Comment ",countQuery = "match(Comment:comment) where Comment.courseid={courseid} return count(*) ")
    Page<comment> findByCourseid(Long courseid,Pageable pageable);
}
