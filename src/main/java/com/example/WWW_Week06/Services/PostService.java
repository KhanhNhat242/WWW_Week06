package com.example.WWW_Week06.Services;

import com.example.WWW_Week06.models.Post;
import com.example.WWW_Week06.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void createOrUpdate(Post p){
        postRepository.save(p);
    }

    public void delete(long id){
        postRepository.deleteById(id);
    }

    public Post findOne(long id){
        return postRepository.findById(id).get();
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
