package com.example.petshelter.DAOs;

import com.example.petshelter.Models.BreedRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRelationRepository extends JpaRepository<BreedRelation, String> {
}