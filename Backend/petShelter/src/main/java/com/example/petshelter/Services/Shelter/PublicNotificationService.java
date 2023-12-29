package com.example.petshelter.Services.Shelter;

import com.example.petshelter.Models.PublicNotification;

import java.util.List;

public interface PublicNotificationService {
    public void insertNotification(String description);
    public List<PublicNotification> getAllNotification();
}
