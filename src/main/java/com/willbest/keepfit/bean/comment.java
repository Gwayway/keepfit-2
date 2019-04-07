package com.willbest.keepfit.bean;

import com.willbest.keepfit.utilandpojo.date;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Data
@NodeEntity(label = "comment")
public class comment {
    @Id
    @GeneratedValue
    private  Long id;
    private  String commentcontent;
    private  String contentownner;
    private  String ownnerphonenum;
    private Long courseid;
    private  String dates=new date().getDate();
    @Relationship(type = "sendcom",direction = Relationship.INCOMING)
    private student student;
    @Relationship(type = "comment",direction = Relationship.OUTGOING)
    private course course;

    public comment(String commentcontent, String contentownner, String ownnerphonenum, Long courseid, com.willbest.keepfit.bean.student student, com.willbest.keepfit.bean.course course) {
        this.commentcontent = commentcontent;
        this.contentownner = contentownner;
        this.ownnerphonenum = ownnerphonenum;
        this.courseid = courseid;
        this.student = student;
        this.course = course;
    }
}
