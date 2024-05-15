package com.post.service.service;

import com.post.service.entity.postModel;
import com.post.service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Optional<postModel> getPostById(Long postId) {
        return postRepository.findById(postId);
    }
    public postModel savePost(postModel post) {
        return postRepository.save(post);
    }
}
