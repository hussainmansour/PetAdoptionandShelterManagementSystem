package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopterRepository extends JpaRepository<Adopter, String> {


}