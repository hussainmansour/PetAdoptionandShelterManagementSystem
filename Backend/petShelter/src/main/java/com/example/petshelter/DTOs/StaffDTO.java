package com.example.petshelter.DTOs;

import com.example.petshelter.Models.Staff;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {
    @NotNull
    @NotBlank
    private String userName;
    @NotNull
    @NotBlank
    private String password;
    private String fname;
    private String lname;
    private String contactNo;
    @NotNull
    @NotBlank
    private String shelterName;
    private String role;
}
