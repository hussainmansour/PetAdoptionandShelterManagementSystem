package com.example.petshelter.DAOs;

import com.example.petshelter.Models.PrivateNotification;
import com.example.petshelter.Models.PublicNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrivateNotificationRepository extends JpaRepository<PrivateNotification, Integer> {
    List<PrivateNotification> findAllByOrderByDate();
}