package com.shark.sharkbank.notification.repo;

import com.shark.sharkbank.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {

}
