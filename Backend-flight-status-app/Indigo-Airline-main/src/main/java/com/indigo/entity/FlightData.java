package com.indigo.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FlightData {
	    @Id
	    @Column(name = "flight_id")
	    private String flightId;

	    @Column(name = "airline")
	    private String airline;

	    @Column(name = "status")
	    private String status;

	    @Column(name = "departure_gate")
	    private String departureGate;

	    @Column(name = "arrival_gate")
	    private String arrivalGate;

	    @Column(name = "scheduled_departure")
	    private ZonedDateTime scheduledDeparture;

	    @Column(name = "scheduled_arrival")
	    private ZonedDateTime scheduledArrival;

	    @Column(name = "actual_departure")
	    private ZonedDateTime actualDeparture;

	    @Column(name = "actual_arrival")
	    private ZonedDateTime actualArrival;
}