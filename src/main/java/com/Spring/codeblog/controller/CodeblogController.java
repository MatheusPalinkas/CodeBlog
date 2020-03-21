package com.Spring.codeblog.controller;

import com.Spring.codeblog.model.Post;
import com.Spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CodeblogController {
    @Autowired
    CodeblogService codeblogService;

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogService.findeAll();

        mv.addObject("posts", posts);
        return mv;
    }
}