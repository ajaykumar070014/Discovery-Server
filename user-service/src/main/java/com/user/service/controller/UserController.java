package com.user.service.controller;

import com.user.service.entity.Notification;
import com.user.service.entity.Post;
import com.user.service.entity.RequiredResponse;
import com.user.service.entity.UserModel;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

//    @GetMapping(value = "/{userId}")
//    public userModel getUserId(@PathVariable("userId") String userId){
//        userModel userOne= new userModel(userId,"Ajay Kumar","123456789");
//        postModel postModel = restTemplate.getForObject("http://POST-SERVICE/post/1", postModel.class);
//        userOne.setPostModel(postModel);
//
//        notificationModel notificationModel=restTemplate.getForObject("http://NOTIFICATION-SERVICE/notification/1",notificationModel.class);
//        userOne.setNotificationModel(notificationModel);
//        return userOne;
//    }

    @PostMapping(path = "/add")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
        UserModel userModelAdd = userRepository.save(userModel);
        return new ResponseEntity<>(userModelAdd, HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<RequiredResponse>getAllUser(@PathVariable Integer id){
        RequiredResponse requiredResponse=new RequiredResponse();
        UserModel userModel=userRepository.findById(id).get();
        requiredResponse.setUserModel(userModel);

        Post listOfPost=restTemplate.getForObject("http://POST-SERVICE/post/"+id,Post.class);
        requiredResponse.setPost(listOfPost);

        Notification listOfNotification=restTemplate.getForObject("http://NOTIFICATION-SERVICE/notification/"+id,Notification.class);
        requiredResponse.setNotification(listOfNotification);

        return new ResponseEntity<>(requiredResponse,HttpStatus.OK);
    }
}
