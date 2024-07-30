package com.indigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indigo.entity.Notification;
import com.indigo.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	EmailReceiver emailReceiver;
	 
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}

	public Notification getNotificationById(Long id) {
		return notificationRepository.findById(id).orElse(null);
	}

	public Notification saveNotification(Notification notification) {
		 notificationRepository.save(notification);
		 if ("Email".equalsIgnoreCase(notification.getMethod())) {
	            emailReceiver.sendEmail(notification);
	        }
		return notification;
	}

	public Notification updateNotification(Long id, Notification notificationDetails) {
		Optional<Notification> notificationOptional = notificationRepository.findById(id);
		if (notificationOptional.isPresent()) {
			Notification notification = notificationOptional.get();
			notification.setFlightId(notificationDetails.getFlightId());
			notification.setMessage(notificationDetails.getMessage());
			notification.setTimestamp(notificationDetails.getTimestamp());
			notification.setMethod(notificationDetails.getMethod());
			notification.setRecipient(notificationDetails.getRecipient());
			return notificationRepository.save(notification);
		}
		return null;
	}

	public boolean deleteNotification(Long id) {
		Optional<Notification> notificationOptional = notificationRepository.findById(id);
		if (notificationOptional.isPresent()) {
			notificationRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
