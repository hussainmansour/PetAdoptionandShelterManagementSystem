package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, String> {
}