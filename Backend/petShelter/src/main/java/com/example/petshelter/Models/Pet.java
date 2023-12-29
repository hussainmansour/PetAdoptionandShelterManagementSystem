package com.example.petshelter.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @Column(name = "health_status", length = 30)
    private String healthStatus;

    @NotNull
    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "breed", nullable = false)
    private BreedRelation breed;

    @Lob
    @Column(name = "description")
    private String description;

    @Size(max = 45)
    @NotNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Size(max = 30)
    @Column(name = "behaviour", length = 30)
    private String behaviour;

    @NotNull
    @Column(name = "isAdopted", nullable = false)
    private Boolean isAdopted = false;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shelter_name", nullable = false)
    private Shelter shelterName;

    @OneToMany(mappedBy = "pet")
    private Set<Application> applications = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pet")
    private Set<Document> documents = new LinkedHashSet<>();

}