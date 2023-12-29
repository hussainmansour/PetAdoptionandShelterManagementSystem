package com.example.petshelter.Controllers;

import com.example.petshelter.Models.PrivateNotification;
import com.example.petshelter.Services.Shelter.PrivateNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/private-notifications")
public class PrivateNotificationController {

    @Autowired
    private PrivateNotificationService privateNotificationService;

    @GetMapping("/getAll")
    public ResponseEntity<List<PrivateNotification>> getAllPrivateNotifications() {
        List<PrivateNotification> privateNotifications = privateNotificationService.getAllprivateNotification();
        return ResponseEntity.ok(privateNotifications);
    }
}