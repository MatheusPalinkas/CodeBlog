package com.Spring.codeblog.service;

import com.Spring.codeblog.model.Post;

import java.util.List;

public interface CodeblogService {

    List<Post> findeAll();
    Post findById(long id);
    Post save(Post post);
    void delete(long id);
    Post update(Post post);
}
