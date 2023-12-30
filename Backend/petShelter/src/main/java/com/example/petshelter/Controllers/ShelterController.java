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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manager/shelters")
public class ShelterController {

    @Autowired
    private ShelterService shelterService;

    @GetMapping("/all")
    public ResponseEntity<List<Shelter>> getAllShelters() {
        List<Shelter> shelters = shelterService.getAllShelter();
        return ResponseEntity.ok(shelters);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertShelter(@Valid @RequestBody ShelterDto shelterDto) {
        System.out.println(shelterDto);
        try {
            return ResponseEntity.ok(shelterService.insertShelter(shelterDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting shelter");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateShelter(@RequestBody ShelterDto shelterDto) {
        System.out.println("gereeeee" + shelterDto);
        try {
            return ResponseEntity.ok(shelterService.updateShelter(shelterDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating shelter");
        }
    }

    @GetMapping("/getShelters/{managerUsername}")
    public ResponseEntity<List<ShelterDto>> getManagerShelters(@PathVariable String managerUsername) {
        List<Shelter> managerShelters = shelterService.getManagerShelters(managerUsername);
        List<ShelterDto> shelterDtoList = new ArrayList<>();

        for (Shelter shelter : managerShelters) {
            ShelterDto shelterDto = new ShelterDto();
            shelterDto.setManagerUsername(shelter.getManagerUsername().getManagerUsername());
            shelterDto.setShelterName(shelter.getName());
            shelterDto.setLocation(shelter.getLocation());
            shelterDto.setContactNo(shelter.getContactNo());
            shelterDtoList.add(shelterDto);
        }
        return ResponseEntity.ok(shelterDtoList);
    }

    //get staffs of a shelter
    @GetMapping("/staffs/{shelterName}")
    public ResponseEntity<List<StaffDTO>> getShelterStaffs(@PathVariable String shelterName) {
        System.out.println(shelterName);
        Set<Staff> shelterStaffs = shelterService.getShelterStaffs(shelterName);
        List<StaffDTO> staffDTOList = new ArrayList<>();

        for (Staff staff : shelterStaffs) {
            StaffDTO staffDTO = new StaffDTO();
            staffDTO.setUserName(staff.getStaffUsername());
            staffDTO.setFname(staff.getFname());
            staffDTO.setLname(staff.getLname());
            staffDTO.setContactNo(staff.getContactNo());
            staffDTO.setRole(staff.getRole());
            staffDTOList.add(staffDTO);
        }

        return ResponseEntity.ok(staffDTOList);
    }

    @PostMapping("/addStaffMember")
    public ResponseEntity<String> addStaffMember(@Valid @RequestBody StaffDTO staffDTO) {
        System.out.println(staffDTO);
        String result = shelterService.addStaffMember(staffDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateStaffMember")
    public ResponseEntity<String> updateStaffMember(@Valid @RequestBody StaffDTO staffDTO) {
        System.out.println("here");
        String result = shelterService.updateStaffMember(staffDTO);
        return ResponseEntity.ok(result);
    }

    // Add more endpoints as needed...

}

