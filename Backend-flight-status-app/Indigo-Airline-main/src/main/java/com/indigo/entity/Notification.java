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
public class Notification {

    @Id
    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "flight_id")
    private String flightId;

    @Column(name = "message")
    private String message;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @Column(name = "method")
    private String method;

    @Column(name = "recipient")
    private String recipient;
}
