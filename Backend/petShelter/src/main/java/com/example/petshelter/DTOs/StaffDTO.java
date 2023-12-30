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
    private String password;
    private String fname;
    private String lname;
    private String contactNo;
    private String shelterName;
    private String role;
}
