package com.example.petshelter.DTOs.Registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationRequestDTO {

    @NotNull
    @NotBlank
    private String username;
    private String contactNo;
    private String fname;
    private String lname;
    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String role;
}
