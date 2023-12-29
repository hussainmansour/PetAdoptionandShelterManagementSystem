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
import jakarta.validation.Valid;
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
    public String insertShelter(ShelterDto shelterDto) {
        if(shelterRepository.findById(shelterDto.getShelterName()).isPresent()){
            return "Shelter is already exists";
        }
        Shelter shelter = Shelter.builder()
                .managerUsername(managerRepository.findById(shelterDto.getManagerUsername()).orElseThrow())
                .name(shelterDto.getShelterName())
                .contactNo(shelterDto.getContactNo())
                .location(shelterDto.getLocation())
                .build();
        shelterRepository.save(shelter);
        return  "Shelter inserted successfully";
    }

    @Override
    public List<Shelter> getManagerShelters(String managerUserName) {
        Manager manager = (Manager) managerRepository.findAllById(Collections.singleton(managerUserName));
        return shelterRepository.findByManagerUsername(manager);
    }

    @Override
    public String updateShelter(ShelterDto shelterDto) {


        if(shelterRepository.findById(shelterDto.getShelterName()).isEmpty()){
            return "shelter is not exist";
        }
        Shelter shelter = shelterRepository.findById(shelterDto.getShelterName()).orElseThrow();
        shelter.setName(shelterDto.getShelterName());
        shelter.setLocation(shelterDto.getLocation());
        shelter.setContactNo(shelterDto.getContactNo());
        shelterRepository.save(shelter);
        return "shelter is updated succesfully";
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
                    .role(staff.getRole())
                    .shelterName(shelterRepository.findById(staff.getShelterName()).orElseThrow())
                    .build();
            staffRepository.save(newStaff);
            return "Staff member added successfully";
        } catch (Exception e) {
            return "Error adding staff member";
        }
    }

    @Override
    public String updateStaffMember(@Valid StaffDTO staff){
        try {
            if(staffRepository.existsById(staff.getUserName())){
                Staff staff1 = staffRepository.findById(staff.getUserName()).orElseThrow();
                staff1.setContactNo(staff.getContactNo());
                staff1.setFname(staff.getFname());
                staff1.setLname(staff.getLname());
                staffRepository.save(staff1);
                return "Staff member updated successfully";

            }
            return "Staff member is not exists";
        } catch (Exception e) {
            return "Error adding staff member";
        }
    }
}

