package com.willbest.keepfit.controller;
import com.willbest.keepfit.bean.comment;
import com.willbest.keepfit.service.CommentService;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/co")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/com",method = RequestMethod.POST)
    public restful  comment(HttpServletRequest request, String commentcontent,Long courseid){
        comment  comment=new comment(commentcontent,null,null,courseid,null,null);
        return commentService.comment(comment,request);
    }
}
