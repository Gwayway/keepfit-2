package com.willbest.keepfit.bean;

import lombok.Data;
import org.neo4j.ogm.annotation.*;
@Data
@RelationshipEntity(type = "order")
public class Order_relationship {
    @Id
    @GeneratedValue
    private Long id;
    @StartNode
    private student student;
    @EndNode
    private course course;

    public Order_relationship(com.willbest.keepfit.bean.student student, com.willbest.keepfit.bean.course course) {
        this.student = student;
        this.course = course;
    }
}
