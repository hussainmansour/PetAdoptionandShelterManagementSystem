package com.example.petshelter.DAOs;

import com.example.petshelter.Models.PublicNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicNotificationRepository extends JpaRepository<PublicNotification, Integer> {
    List<PublicNotification> findAllByOrderByDate();
}