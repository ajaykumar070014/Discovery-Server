package com.post.service.controller;

import com.post.service.entity.postModel;
import com.post.service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class postController {

    @Autowired
    private PostService postService;

    @GetMapping("/{postId}")
    public postModel getPostById(@PathVariable Long postId){
        return postService.getPostById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
    }
    @PostMapping
    public postModel createPost(@RequestBody postModel postModel){
        return postService.savePost(postModel);
    }
//    @GetMapping(value = "{postId}")
//    public postModel getpostId(@PathVariable("postId") Long postId){
//        postModel postOne=new postModel(postId,"Your post has been successfully updated");
//        return postOne;
//    }

}
