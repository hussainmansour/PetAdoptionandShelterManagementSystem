package com.example.petshelter.Services.Registration;

import com.example.petshelter.DAOs.AdopterRepository;
import com.example.petshelter.DAOs.ManagerRepository;
import com.example.petshelter.DAOs.StaffRepository;
import com.example.petshelter.DTOs.Registration.RegistrationRequestDTO;
import com.example.petshelter.Enums.ErrorCode;
import com.example.petshelter.Exceptions.GlobalException;
import com.example.petshelter.Models.Adopter;
import com.example.petshelter.Models.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class RegistrationService {

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean register(RegistrationRequestDTO registrationRequest) {
        System.out.println(passwordEncoder.encode(registrationRequest.getPassword()));
        if (checkUserCredentials(registrationRequest)) {
            switch (registrationRequest.getRole().toLowerCase()) {
                case "adopter" ->
                    adopterRepository.save(
                            Adopter.builder()
                                    .adopterUsername(registrationRequest.getUsername())
                                    .password(passwordEncoder.encode(registrationRequest.getPassword()))
                                    .fname(registrationRequest.getFname())
                                    .lname(registrationRequest.getLname())
                                    .contactNo(registrationRequest.getContactNo())
                                    .build()
                    );
                case "manager" -> managerRepository.save(
                        Manager.builder()
                                .managerUsername(registrationRequest.getUsername())
                                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                                .fname(registrationRequest.getFname())
                                .lname(registrationRequest.getLname())
                                .contactNo(registrationRequest.getContactNo())
                                .build()
                );
            }
            return true;
        }
        return false;
    }


    private boolean checkUserCredentials(RegistrationRequestDTO registrationRequest){

        return !adopterRepository.existsById(registrationRequest.getUsername()) &&
                !managerRepository.existsById(registrationRequest.getUsername()) &&
                !staffRepository.existsById(registrationRequest.getUsername());

    }
}