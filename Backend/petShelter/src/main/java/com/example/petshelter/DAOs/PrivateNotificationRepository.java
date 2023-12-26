package com.example.petshelter.DAOs;

import com.example.petshelter.Models.PrivateNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivateNotificationRepository extends JpaRepository<PrivateNotification, Integer> {
}