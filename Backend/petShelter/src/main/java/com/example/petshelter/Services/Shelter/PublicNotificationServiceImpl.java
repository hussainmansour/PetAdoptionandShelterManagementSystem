package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.PublicNotificationRepository;
import com.example.petshelter.Models.PublicNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PublicNotificationServiceImpl implements  PublicNotificationService{

    @Autowired
    PublicNotificationRepository publicNotificationRepository;

    public void insertNotification(String description){
        PublicNotification publicNotification =  PublicNotification.builder()
                .description(description)
                .date((Date) new Date())
                .build();

        publicNotificationRepository.save(publicNotification);
    }
    public List<PublicNotification> getAllNotification(){
        return publicNotificationRepository.findAllByOrderByDate();
    }

}
