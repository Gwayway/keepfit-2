package com.willbest.keepfit.controller;
import com.willbest.keepfit.bean.comment;
import com.willbest.keepfit.service.CommentService;
import com.willbest.keepfit.utilandpojo.restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/co")
public class CommentController {
    @Autowired
    CommentService commentService;
    @RequestMapping(value = "/com",method = RequestMethod.POST)
    public restful  comment(String commentcontent, String contenownner,String ownnerphonenum,Long courseid){
        comment  comment=new comment(commentcontent,contenownner,ownnerphonenum,courseid,null,null);
        return commentService.comment(comment);
    }
}
