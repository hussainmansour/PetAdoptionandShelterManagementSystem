package com.example.petshelter.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "breed_relation")
public class BreedRelation {
    @Id
    @Size(max = 45)
    @Column(name = "breed_id", nullable = false, length = 45)
    private String breedId;

    @Size(max = 45)
    @Column(name = "species", length = 45)
    private String species;

    @OneToMany(mappedBy = "breed")
    private Set<Pet> pets = new LinkedHashSet<>();

}