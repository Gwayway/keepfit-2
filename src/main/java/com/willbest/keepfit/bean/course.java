package com.willbest.keepfit.bean;
import com.willbest.keepfit.utilandpojo.Tool;
import com.willbest.keepfit.utilandpojo.date;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.domain.Page;

import java.util.List;
@Data
@NodeEntity(label = "course")
public class course {
    @Id
    @GeneratedValue
    private  Long id;
    private  String img_src=null;
    private  Integer start_count=0;
    private  String course_type="运动";
    private String title;
    private  String coursename;
    private List<String> picurl;
    private Integer img_num=0;
    private  String courseownner;
    private  String introduce;
    private String phonenum;
    private  String dates=new date().getDate();
    private Integer tagNum=3;
    @Relationship(type = "release",direction = Relationship.INCOMING)
    private teacher teacher;
    static {

    }
    public course(Long id, String coursename, List<String> picurl, String courseownner, String introduce, com.willbest.keepfit.bean.teacher teacher,String phonenum,String tag) {
        this.id = id;
        this.coursename = coursename;
        this.picurl = picurl;
        this.courseownner = courseownner;
        this.introduce = introduce;
        this.teacher = teacher;
        this.phonenum=phonenum;
        if(picurl!=null){
            this.img_num=picurl.size();
            this.img_src=picurl.get(0);
        }else {
            this.img_num=0;
        }
        this.title=coursename;
        this.course_type=tag;
    }
}
