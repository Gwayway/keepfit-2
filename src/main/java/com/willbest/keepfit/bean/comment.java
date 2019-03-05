package com.willbest.keepfit.bean;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
@Data
@NodeEntity(label = "comment")
public class comment {
    @Id
    @GeneratedValue
    private  Long id;
    private  String commentcontent;
    private  String contentownner;
}
