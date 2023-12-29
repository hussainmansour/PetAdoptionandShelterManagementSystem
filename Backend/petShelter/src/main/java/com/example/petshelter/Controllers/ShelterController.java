package com.example.petshelter.Controllers;

import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;
import com.example.petshelter.Services.Shelter.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping("/all")
    public ResponseEntity<List<Shelter>> getAllShelters() {
        List<Shelter> shelters = shelterService.getAllShelter();
        return ResponseEntity.ok(shelters);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertShelter(@RequestBody Shelter shelter) {
        try {
            shelterService.insertShelter(shelter);
            return ResponseEntity.ok("Shelter inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting shelter");
        }
    }

    @GetMapping("/manager/{managerUsername}")
    public ResponseEntity<List<Shelter>> getManagerShelters(@PathVariable String managerUsername) {
        List<Shelter> managerShelters = shelterService.getManagerShelters(managerUsername);
        return ResponseEntity.ok(managerShelters);
    }

    // Add more endpoints as needed...

}

