package com.Spring.codeblog.utils;

import com.Spring.codeblog.model.Post;
import com.Spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {
    @Autowired
    CodeblogRepository codeblogRepository;

    //Será executado quando a aplicação subir
    //@PostConstruct
    public void savePosts(){
        List<Post> listPost = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Palinkas");
        post1.setData(LocalDate.now());
        post1.setTitulo("Diferença entre os metodos GET e POST");
        post1.setTexto("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        Post post2 = new Post();
        post2.setAutor("Matheus");
        post2.setData(LocalDate.now());
        post2.setTitulo("DotNet");
        post2.setTexto("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        listPost.add(post1);
        listPost.add(post2);

        for (Post post: listPost) {
            Post postSave = codeblogRepository.save(post);
            System.out.println(postSave.getId());
        }
    }
}
