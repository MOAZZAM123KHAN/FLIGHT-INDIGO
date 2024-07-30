package com.indigo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indigo.entity.Notification;
import com.indigo.response.Response;
import com.indigo.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	

	@GetMapping("/{id}")
    public ResponseEntity<Response> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        if (notification == null) {
            return new ResponseEntity<>(new Response(Collections.emptyList(), true, "Notification not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Response(Collections.singletonList(notification), false, "Notification retrieved successfully"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return new ResponseEntity<>(new Response(notifications, false, "Notifications retrieved successfully"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> createNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.saveNotification(notification);
        return new ResponseEntity<>(new Response(Collections.singletonList(savedNotification), false, "Notification created successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateNotification(@PathVariable Long id, @RequestBody Notification notificationDetails) {
        Notification updatedNotification = notificationService.updateNotification(id, notificationDetails);
        if (updatedNotification == null) {
            return new ResponseEntity<>(new Response(Collections.emptyList(), true, "Notification not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Response(Collections.singletonList(updatedNotification), false, "Notification updated successfully"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteNotification(@PathVariable Long id) {
        boolean deleteNotification = notificationService.deleteNotification(id);
        if (!deleteNotification) {
            return new ResponseEntity<>(new Response(Collections.emptyList(), true, "Notification not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Response(Collections.emptyList(), false, "Notification deleted successfully"), HttpStatus.NO_CONTENT);
    }
    
}
