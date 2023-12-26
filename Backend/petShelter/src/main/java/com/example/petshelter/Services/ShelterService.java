package com.example.petshelter.Services;

import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShelterService {
    List<Shelter> getAllShelter();
    ResponseEntity insertShelter(Shelter shelter);
    List<Shelter> getManagerShelters(Manager manager);

}
