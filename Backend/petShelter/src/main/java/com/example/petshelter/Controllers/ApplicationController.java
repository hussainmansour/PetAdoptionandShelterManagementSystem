package com.example.petshelter.Controllers;

import com.example.petshelter.DTOs.ApplicationDTO;
import com.example.petshelter.DTOs.InsertApplicationDTO;
import com.example.petshelter.DTOs.UpdateApplicationDTO;
import com.example.petshelter.Models.Application;
import com.example.petshelter.Services.Shelter.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/test/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/all")
    public ResponseEntity<List<ApplicationDTO>> getAllApplications() {
        List<ApplicationDTO> applications = applicationService.getAllApplication();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<ApplicationDTO>> getPetApplications(@PathVariable Integer petId) {
        System.out.println("here1");
        List<ApplicationDTO> applications = applicationService.getPetApplication(petId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/adopter/{adopterUserName}")
    public ResponseEntity<List<ApplicationDTO>> getAdopterApplications(@PathVariable String adopterUserName) {
        List<ApplicationDTO> applications = applicationService.getAdopterApplication(adopterUserName);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/acceptedRecords")
    public ResponseEntity<List<ApplicationDTO>> getAcceptedApplications(@RequestParam String adopterUserName) {
        try {
            List<ApplicationDTO> applications = applicationService.getAcceptedApplication(adopterUserName);
            System.out.println(applications.size());
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            List<ApplicationDTO> result = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @GetMapping("/pending")
    public ResponseEntity<List<ApplicationDTO>> getPendingApplications(@RequestParam String shelterName) {
        try {
            List<ApplicationDTO> applications = applicationService.getPendingApplication(shelterName);
            System.out.println(applications.size());
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            List<ApplicationDTO> result = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }



    @GetMapping("/records")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsRecords(@RequestParam String adopterUserName) {
        try {
            List<ApplicationDTO> applications = applicationService.getAcceptedOrRefusedApplication(adopterUserName);
            System.out.println(applications.size());
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            List<ApplicationDTO> result = new ArrayList<>();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertApplication(
            @RequestBody InsertApplicationDTO insertApplicationDTO
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
            @RequestBody UpdateApplicationDTO updateApplicationDTO
            ) {
        try {
            String result = applicationService.updateApplication(updateApplicationDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating application");
        }
    }

}

