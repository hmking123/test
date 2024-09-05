package com.example.project_management_app.service;

import com.example.project_management_app.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    Notification addNotification(Notification notification);

    Optional<Notification> getNotificationById(Long id);

    List<Notification> getNotificationsByUserId(Long userId);

    List<Notification> getUnreadNotificationsByUserId(Long userId);

    Notification markAsRead(Long notificationId);

    void removeNotification(Long id);
}
