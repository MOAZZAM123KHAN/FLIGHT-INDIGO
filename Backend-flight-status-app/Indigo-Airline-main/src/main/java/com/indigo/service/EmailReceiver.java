package com.indigo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.indigo.entity.Notification;

@Service
public class EmailReceiver {

    @Autowired
    private JavaMailSender emailSender;

    public void receiveMessage(Notification notification) {
        if ("Email".equalsIgnoreCase(notification.getMethod())) {
            sendEmail(notification);
        }
    }

    public void sendEmail(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getRecipient());
        message.setSubject("Flight Notification");
        message.setText(notification.getMessage());
        emailSender.send(message);
    }
}
