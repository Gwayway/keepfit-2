package com.willbest.keepfit.mapper;
import com.willbest.keepfit.bean.course;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CourseMapper extends Neo4jRepository <course,Long>{

}
