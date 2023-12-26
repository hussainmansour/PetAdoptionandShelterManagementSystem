package com.example.petshelter.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "public_notification")
public class PublicNotification {
    @Id
    @Column(name = "notification_id", nullable = false)
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @Lob
    @Column(name = "description")
    private String description;

}