package com.willbest.keepfit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

@AllArgsConstructor
@Data
@RelationshipEntity(type = "like")
public class Like_relationship {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private student student;
    @EndNode
    private course course;
}
