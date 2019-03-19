package com.willbest.keepfit.utilandpojo;

import lombok.Data;
@Data
public class PageList{
    private  Integer currentPage=1;
    private  Integer pageSize=10;
    private  String type;

    public PageList(Integer currentPage, Integer pageSize, String type) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.type = type;
    }
}
