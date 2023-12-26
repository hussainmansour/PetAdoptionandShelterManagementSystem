package com.example.petshelter.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "breed_relation")
public class BreedRelation {
    @Id
    @Size(max = 45)
    @Column(name = "breed_id", nullable = false, length = 45)
    private String breedId;

    @Size(max = 45)
    @Column(name = "species", length = 45)
    private String species;

}