package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}