package com.willbest.keepfit.controller;

import com.willbest.keepfit.service.ListService;
import com.willbest.keepfit.utilandpojo.PageList;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/list",method = RequestMethod.GET)
public class ListController {
    @Autowired
    ListService listService;
    public restful listdata(HttpServletRequest request,String type,Integer currentpage,Integer pagesize){
        return  listService.list(request,new PageList(currentpage,pagesize,type));
    }
}
