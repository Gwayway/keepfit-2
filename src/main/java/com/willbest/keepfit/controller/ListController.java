package com.willbest.keepfit.controller;

import com.willbest.keepfit.bean.course;
import com.willbest.keepfit.service.ListService;
import com.willbest.keepfit.utilandpojo.PageList;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/list",method = RequestMethod.GET)
public class ListController {
    @Autowired
    ListService listService;
    @RequestMapping(value = "/ls",method = RequestMethod.GET)
    public restful listdata(HttpServletRequest request,String type,Integer currentpage,Integer pagesize,Long depent){
        return  listService.list(request,new PageList(currentpage,pagesize,type,depent));
    }
    @RequestMapping("/dbls")
    public List db_course(HttpServletRequest request,Integer currentpage){
        return listService.double_list(request,new PageList(currentpage,6,null,null));
    }
    @RequestMapping("/taglist")
    public  List tagList(HttpServletRequest request,Integer currentpage,Integer tag){
        return listService.taglist(request,new PageList(currentpage,6,null,null),tag);
    }
}
