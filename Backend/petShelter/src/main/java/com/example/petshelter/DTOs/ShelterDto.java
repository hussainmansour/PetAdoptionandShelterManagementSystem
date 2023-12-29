package com.example.petshelter.DTOs;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShelterDto {

    private String managerUsername;
    @NotNull
    @NotBlank
    private String ShelterName ;
    private String location;
    private String contactNo;
}
