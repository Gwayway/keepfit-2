package com.willbest.keepfit.bean;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
@NodeEntity(label = "teacher")
@Data
public class teacher {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private  String nickname;
    private  String password;
    @Index(unique = true)
    private  String phonenum;
    public  teacher(String username,String nickname,String password ,String phonenum){
        this.username=username;
        this.nickname=nickname;
        this.password=password;
        this.phonenum=phonenum;

    }
}

