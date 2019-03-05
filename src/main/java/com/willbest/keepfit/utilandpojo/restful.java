package com.willbest.keepfit.utilandpojo;

import lombok.Data;

@Data
public class restful<T> {
    private  String msg;
    private String type;
    private  T data;
    public  restful(String msg,T data,String type){
        this.msg=msg;
        this.data=data;
        this.type=type;
    }
}
