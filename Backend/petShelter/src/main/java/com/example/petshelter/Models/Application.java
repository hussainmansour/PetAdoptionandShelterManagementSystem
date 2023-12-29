package com.example.petshelter.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application")
public class Application {
    @EmbeddedId
    private ApplicationId id;

    @MapsId("petId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @MapsId("adopterUsername")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "adopter_username", nullable = false)
    private Adopter adopterUsername;

    @NotNull
    @Lob
    @Column(name = "status", nullable = false)
    private String status;

    @NotNull
    @Column(name = "date", nullable = false)
    private Date date;

}