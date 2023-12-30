package com.example.petshelter.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
public class UpdateStaffDTO {
    private String userName;
    private String fname;
    private String lname;
    private String contactNo;
}
