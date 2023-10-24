package com.example.WWW_Week06.Services;

import com.example.WWW_Week06.models.PostComment;
import com.example.WWW_Week06.repositories.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;

    public void createOrUpdate(PostComment pc){
        postCommentRepository.save(pc);
    }

    public void delete(long id){
        postCommentRepository.deleteById(id);
    }

    public PostComment findOne(long id){
        return postCommentRepository.findById(id).get();
    }

    public List<PostComment> findAll(){
        return postCommentRepository.findAll();
    }
}
