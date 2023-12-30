package com.example.petshelter.DTOs;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPetDTO {
    private Integer petId;
    private String name;
    private String date;
    private String gender;
    private String shelterName;

 }
