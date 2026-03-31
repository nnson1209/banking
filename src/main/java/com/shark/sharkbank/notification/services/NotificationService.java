package com.shark.sharkbank.notification.services;

import com.shark.sharkbank.auth_users.entity.User;
import com.shark.sharkbank.notification.dtos.NotificationDTO;

public interface NotificationService {
    void sendEmail(NotificationDTO notificationDTO, User user);
}
