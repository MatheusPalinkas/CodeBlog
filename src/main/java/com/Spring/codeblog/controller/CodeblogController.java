package com.Spring.codeblog.controller;

import com.Spring.codeblog.model.Post;
import com.Spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
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

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = codeblogService.findById(id);

        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public ModelAndView getPostForm(){
        ModelAndView mv = new ModelAndView("newPost");
        Post post = new Post();

        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors())
            return "redirect:/newpost";

        post.setData(LocalDate.now());
        codeblogService.save(post);

        return  "redirect:/posts";
    }

    @RequestMapping(value = "/posts/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") long id){
        codeblogService.delete(id);
        return  "redirect:/posts";
    }

    @RequestMapping(value = "/posts/update/{id}", method = RequestMethod.GET)
    public ModelAndView getPostUpdateForm(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("newPost");
        Post post = codeblogService.findById(id);

        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/posts/update/{id}", method = RequestMethod.POST)
    public String updatePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors())
            return "redirect:/newpost";

        codeblogService.update(post);

        return  "redirect:/posts";
    }
}
