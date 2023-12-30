package com.example.petshelter.Controllers;

import com.example.petshelter.DAOs.StaffRepository;
import com.example.petshelter.DTOs.ShelterDto;
import com.example.petshelter.DTOs.StaffDTO;
import com.example.petshelter.DTOs.UpdateStaffDTO;
import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;
import com.example.petshelter.Models.Staff;
import com.example.petshelter.Services.Shelter.ShelterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/staff/shelters")
public class StaffMemberController {

    @Autowired
    private ShelterService shelterService;

    @Autowired
    private StaffRepository staffRepository;
    @PostMapping("/updateStaffMember")
    public ResponseEntity<String> updateStaffMember( @RequestBody UpdateStaffDTO staffDTO) {
        System.out.println("here");
        System.out.println(staffDTO);
        String result = shelterService.updateStaffMember(staffDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getShelterName/{staffUsername}")
    public ResponseEntity<String> getShelterName(@PathVariable String staffUsername) {
        System.out.println(staffUsername);
        try {
            staffRepository.findById(staffUsername).orElseThrow();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Staff member not found");
        }
        String shelterName = staffRepository.findById(staffUsername).get().getShelterName().getName();
        return ResponseEntity.ok(shelterName);
    }

}

