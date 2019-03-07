package com.willbest.keepfit.mapper;

import com.willbest.keepfit.bean.comment;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CommentMapper extends Neo4jRepository<comment,Long> {
}
