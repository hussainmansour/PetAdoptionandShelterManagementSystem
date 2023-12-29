package com.example.petshelter.Controllers;

import com.example.petshelter.DTOs.Registration.RegistrationRequestDTO;
import com.example.petshelter.Exceptions.GlobalException;
import com.example.petshelter.Services.Registration.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegisterationController {


    @Autowired
    private RegistrationService registrationService;


    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequestDTO request) {

        if(registrationService.register(request))
            return ResponseEntity
                .ok("successful registration");
        return ResponseEntity
                .badRequest()
                .body("username already exists");
    }
}