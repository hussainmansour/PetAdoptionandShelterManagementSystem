package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DTOs.ShelterDto;
import com.example.petshelter.DTOs.StaffDTO;
import com.example.petshelter.Models.Shelter;
import com.example.petshelter.Models.Staff;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface ShelterService {
    List<Shelter> getAllShelter();
    String insertShelter(ShelterDto shelterDto);
    List<Shelter> getManagerShelters(String managerUserName);

    String updateShelter(ShelterDto shelterDto);

    Set<Staff> getShelterStaffs(String shelterName);

    String addStaffMember(@Valid StaffDTO staff);

    String updateStaffMember(@Valid StaffDTO staff);
}
