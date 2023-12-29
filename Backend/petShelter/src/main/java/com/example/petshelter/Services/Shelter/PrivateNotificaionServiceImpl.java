package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.PrivateNotificationRepository;
import com.example.petshelter.Models.PrivateNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrivateNotificaionServiceImpl implements PrivateNotificationService {
    @Autowired
    PrivateNotificationRepository privateNotificationRepository;
    public List<PrivateNotification> getAllprivateNotification(){
        return privateNotificationRepository.findAllByOrderByDate();
    }
}
