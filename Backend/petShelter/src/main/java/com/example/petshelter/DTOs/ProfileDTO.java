package com.example.petshelter.DTOs;

import com.example.petshelter.Models.Application;
import com.example.petshelter.Models.BreedRelation;
import com.example.petshelter.Models.Document;
import com.example.petshelter.Models.Shelter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private Integer id;
    private String healthStatus;
    private String gender;
    private LocalDate dateOfBirth;
    private String breed;
    private String species;
    private String description;
    private String name;
    private String behaviour;
    private Boolean isAdopted ;
    private String shelterName;
    private List<ApplicationDTO> applications ;
    private List<DocumentDTO> documents;
}
