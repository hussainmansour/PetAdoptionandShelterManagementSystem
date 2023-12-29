package com.example.petshelter.DTOs;


import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class ShelterDto {

    private String managerUsername;
    private String ShelterName ;
    private String location;
    private String contactNo;
}
