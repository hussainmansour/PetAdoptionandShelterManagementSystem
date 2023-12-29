package com.example.petshelter.Controllers;

import com.example.petshelter.DTOs.InsertApplicationDTO;
import com.example.petshelter.DTOs.UpdateApplicationDTO;
import com.example.petshelter.Models.Application;
import com.example.petshelter.Services.Shelter.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/all")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplication();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<Application>> getPetApplications(@PathVariable Integer petId) {
        List<Application> applications = applicationService.getPetApplication(petId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/adopter/{adopterUserName}")
    public ResponseEntity<List<Application>> getAdopterApplications(@PathVariable String adopterUserName) {
        List<Application> applications = applicationService.getAdopterApplication(adopterUserName);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/accepted/{adopterUserName}")
    public ResponseEntity<List<Application>> getAcceptedApplications(@PathVariable String adopterUserName) {
        List<Application> applications = applicationService.getAcceptedApplication(adopterUserName);
        return ResponseEntity.ok(applications);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertApplication(
            @RequestParam InsertApplicationDTO insertApplicationDTO
            ) {
        try {
            String result = applicationService.insertApplication(insertApplicationDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting application");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateApplication(
            @RequestParam UpdateApplicationDTO updateApplicationDTO
            ) {
        try {
            String result = applicationService.updateApplication(updateApplicationDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating application");
        }
    }

}

