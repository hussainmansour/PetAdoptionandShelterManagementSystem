package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, String> {
}