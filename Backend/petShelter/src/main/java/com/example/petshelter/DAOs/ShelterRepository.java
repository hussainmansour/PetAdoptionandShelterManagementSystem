package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelterRepository extends JpaRepository<Shelter, String> {

    List<Shelter> findByManagerUsername(Manager managerUsername);
}