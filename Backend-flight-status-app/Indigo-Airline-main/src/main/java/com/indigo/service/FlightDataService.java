package com.indigo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indigo.entity.FlightData;
import com.indigo.entity.Notification;
import com.indigo.repository.FlightRepository;

@Service
public class FlightDataService {

	@Autowired
	private FlightRepository flightDataRepository;
	@Autowired
	private NotificationService notificationService;

	public void saveFlightData(List<FlightData> flightDataList) {
		flightDataRepository.saveAll(flightDataList);
	}

	public List<FlightData> getAllFlightData() {
		return flightDataRepository.findAll();
	}

	public void updateFlightStatus(String flightId, String newStatus) {
		Notification notification = new Notification();
		notification.setFlightId(flightId);
		notification.setMessage("Your flight " + flightId + " is now " + newStatus + ".");
		notification.setMethod("Email");
		notification.setRecipient("aasifali1088@gmail.com");
		notificationService.saveNotification(notification);
	}
}
