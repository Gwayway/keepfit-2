package com.willbest.keepfit.mapper;

import com.willbest.keepfit.bean.comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface CommentMapper extends Neo4jRepository<comment,Long> {
    Page<comment> findAllById(@Param("id") Long id, Pageable pageable);
}
