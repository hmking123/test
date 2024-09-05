package com.example.project_management_app.service;

import com.example.project_management_app.model.Notification;
import com.example.project_management_app.repository.NotificationRepository;
import com.example.project_management_app.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public List<Notification> getUnreadNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserIdAndIsRead(userId, false);
    }

    @Override
    public Notification markAsRead(Long notificationId) {
        Optional<Notification> notification = notificationRepository.findById(notificationId);
        if (notification.isPresent()) {
            Notification updatedNotification = notification.get();
            updatedNotification.setIsRead(true);
            return notificationRepository.save(updatedNotification);
        }
        return null;
    }

    @Override
    public void removeNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
