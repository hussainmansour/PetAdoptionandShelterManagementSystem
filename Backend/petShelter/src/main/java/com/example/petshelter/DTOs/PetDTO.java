package com.example.petshelter.DTOs;

import com.example.petshelter.Models.BreedRelation;
import com.example.petshelter.Models.Shelter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class PetDTO {

    private String healthStatus;
    private String gender;
    private LocalDate dateOfBirth;
    private String breed;
    private String description;
    private String name;
    private String behaviour;
    private String shelterName;
    private  String species;
}
