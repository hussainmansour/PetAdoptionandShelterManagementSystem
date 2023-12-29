package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.AdopterRepository;
import com.example.petshelter.DAOs.ManagerRepository;
import com.example.petshelter.DAOs.ShelterRepository;
import com.example.petshelter.DAOs.StaffRepository;
import com.example.petshelter.DTOs.ShelterDto;
import com.example.petshelter.DTOs.StaffDTO;
import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;
import com.example.petshelter.Models.Staff;
import com.example.petshelter.Services.Shelter.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ShelterServiceImpl implements ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public List<Shelter> getAllShelter() {
        List<Shelter> all = shelterRepository.findAll();
        return all;
    }

    @Override
    public ResponseEntity insertShelter(ShelterDto shelterDto) {
        Shelter shelter = Shelter.builder()
                //.managerUsername(managerRepository.findById(shelterDto.managerUsername).orElseThrow())
                .name(shelterDto.ShelterName)
                .contactNo(shelterDto.contactNo)
                .build();
        shelterRepository.save(shelter);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @Override
    public List<Shelter> getManagerShelters(String managerUserName) {
        Manager manager = (Manager) managerRepository.findAllById(Collections.singleton(managerUserName));
        return shelterRepository.findByManagerUsername(manager);
    }

    @Override
    public ResponseEntity updateShelter(ShelterDto shelterDto) {
        Shelter shelter = shelterRepository.findById(shelterDto.ShelterName).orElseThrow();
        shelter.setName(shelterDto.ShelterName);
        shelter.setContactNo(shelterDto.contactNo);
        shelterRepository.save(shelter);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @Override
    public Set<Staff> getShelterStaffs(String shelterName) {
        return shelterRepository.findById(shelterName).orElseThrow().getStaff();
    }

    @Override
    public String addStaffMember(StaffDTO staff) {

        if(staffRepository.existsById(staff.getUserName())){
            return "Staff member already exists";
        }
        if(adopterRepository.existsById(staff.getUserName())||managerRepository.existsById(staff.getUserName())){
            return "Username already exists";
        }
        try {
            Staff newStaff = Staff.builder()
                    .staffUsername(staff.getUserName())
                    .fname(staff.getFname())
                    .lname(staff.getLname())
                    .password(passwordEncoder.encode(staff.getPassword()))
                    .contactNo(staff.getContactNo())
                    .shelterName(shelterRepository.findById(staff.getShelterName()).orElseThrow())
                    .build();
            staffRepository.save(newStaff);
            return "Staff member added successfully";
        } catch (Exception e) {
            return "Error adding staff member";
        }
    }
}

