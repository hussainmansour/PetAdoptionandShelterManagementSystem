package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdopterRepository extends JpaRepository<Adopter, String> {

}