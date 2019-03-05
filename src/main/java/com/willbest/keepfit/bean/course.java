package com.willbest.keepfit.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.model.Node;
import org.neo4j.ogm.response.model.NodeModel;

import java.util.List;
@AllArgsConstructor
@Data
@NodeEntity(label = "course")
public class course {
    @Id
    @GeneratedValue
    private  Long id;
    private  String coursename;
    private List<String> picurl;
    private  String courseownner;
    private  String introduce;
    @Relationship(type = "release",direction = Relationship.INCOMING)
    private NodeModel node;
}
