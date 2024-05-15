package com.notification.service.controller;

import com.notification.service.entity.Notification;
import com.notification.service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

//    @GetMapping(value = "/{notificationId}")
//    public Notification getnotificationId(@PathVariable("notificationId") String notificationId){
//        Notification notificationOne= new Notification(notificationId,"Hello Ajay");
//        return notificationOne;
//    }

    @GetMapping(path = "/{notificationId}")
    public Notification getNotificationById(@PathVariable int notificationId){
        return notificationService.getNotificationById(notificationId).orElseThrow(()-> new RuntimeException("Notification not found"));
    }
    @PostMapping(path = "/add")
    private Notification addNotification(@RequestBody Notification notification){
        return notificationService.addNotification(notification);
    }
}
