package com.willbest.keepfit.utilandpojo;

import lombok.Data;
@Data
public class PageList{
    private  Integer currentPage;
    private  Integer pageSize;
    private  String type;
    private  Long depent;

    public PageList(Integer currentPage, Integer pageSize, String type, Long depent) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.type = type;
        this.depent = depent;
    }
}
