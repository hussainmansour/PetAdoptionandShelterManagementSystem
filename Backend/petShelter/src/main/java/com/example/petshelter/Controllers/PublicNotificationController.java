package com.example.petshelter.Controllers;


import com.example.petshelter.Models.PublicNotification;
import com.example.petshelter.Services.Shelter.PublicNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/public-notifications")
public class PublicNotificationController {

    @Autowired
    private PublicNotificationService publicNotificationService;

    @PostMapping("/insert")
    public ResponseEntity<String> insertNotification(@RequestParam String description) {
        try {
            publicNotificationService.insertNotification(description);
            return ResponseEntity.ok("Notification inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting notification");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PublicNotification>> getAllNotifications() {
        List<PublicNotification> notifications = publicNotificationService.getAllNotification();
        return ResponseEntity.ok(notifications);
    }
}