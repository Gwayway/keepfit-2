package com.willbest.keepfit.bean;
import com.willbest.keepfit.utilandpojo.date;
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
    private String phonenum;
    private  String dates=new date().getDate();
    @Relationship(type = "release",direction = Relationship.INCOMING)
    private teacher teacher;

    public course(Long id, String coursename, List<String> picurl, String courseownner, String introduce, com.willbest.keepfit.bean.teacher teacher,String phonenum) {
        this.id = id;
        this.coursename = coursename;
        this.picurl = picurl;
        this.courseownner = courseownner;
        this.introduce = introduce;
        this.teacher = teacher;
        this.phonenum=phonenum;
    }
}
