package com.example.petshelter.Controllers;

import com.example.petshelter.DTOs.Login.AuthenticationRequestDTO;
import com.example.petshelter.Services.Login.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String>
    login(@Valid @RequestBody AuthenticationRequestDTO authenticationRequest) {
        System.out.println(authenticationRequest.toString());
        String token = authenticationService.authenticate(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword());
        return ResponseEntity.ok(token);
    }
}
