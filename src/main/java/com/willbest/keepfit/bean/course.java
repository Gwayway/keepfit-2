package com.willbest.keepfit.bean;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import java.util.List;
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
    private teacher teacher;

    public course(Long id, String coursename, List<String> picurl, String courseownner, String introduce, com.willbest.keepfit.bean.teacher teacher) {
        this.id = id;
        this.coursename = coursename;
        this.picurl = picurl;
        this.courseownner = courseownner;
        this.introduce = introduce;
        this.teacher = teacher;
    }
}
