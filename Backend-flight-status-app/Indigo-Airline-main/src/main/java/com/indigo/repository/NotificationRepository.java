package com.indigo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indigo.entity.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
