package com.willbest.keepfit.utilandpojo;


import java.text.SimpleDateFormat;
import java.util.Date;
public class date {
    public  String getDate() {
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        return str;// 当前时间
    }

}
