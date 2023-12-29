package com.example.petshelter.Controllers;

import com.example.petshelter.DTOs.ShelterDto;
import com.example.petshelter.DTOs.StaffDTO;
import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;
import com.example.petshelter.Models.Staff;
import com.example.petshelter.Services.Shelter.ShelterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    public ResponseEntity<String> insertShelter(@RequestBody ShelterDto shelterDto) {
        try {
            shelterService.insertShelter(shelterDto);
            return ResponseEntity.ok("Shelter inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting shelter");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateShelter(@RequestBody ShelterDto shelterDto) {
        try {
            shelterService.updateShelter(shelterDto);
            return ResponseEntity.ok("Shelter updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating shelter");
        }
    }

    @GetMapping("/manager/{managerUsername}")
    public ResponseEntity<List<Shelter>> getManagerShelters(@PathVariable String managerUsername) {
        List<Shelter> managerShelters = shelterService.getManagerShelters(managerUsername);
        return ResponseEntity.ok(managerShelters);
    }

    //get staffs of a shelter
    @GetMapping("/staffs/{shelterName}")
    public ResponseEntity<Set<Staff>> getShelterStaffs(@PathVariable String shelterName) {
        Set<Staff> shelterStaffs = shelterService.getShelterStaffs(shelterName);
        return ResponseEntity.ok(shelterStaffs);
    }

    @PostMapping("/addStaffMember")
    public ResponseEntity<String> addStaffMember(@Valid @RequestBody StaffDTO staffDTO) {
        String result = shelterService.addStaffMember(staffDTO);
        return ResponseEntity.ok(result);
    }

    // Add more endpoints as needed...

}
