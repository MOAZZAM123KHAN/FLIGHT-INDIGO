package com.indigo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.indigo.entity.Notification;

@Service
public class NotificationConsumer {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = "email_notifications")
    public void receiveMessage(Notification notification) {
        sendEmail(notification);
    }

    private void sendEmail(Notification notification) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(notification.getRecipient());
        message.setSubject("Flight Notification");
        message.setText(notification.getMessage());
        mailSender.send(message);
    }
}
