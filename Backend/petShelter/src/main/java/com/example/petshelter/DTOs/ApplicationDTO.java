package com.example.petshelter.DTOs;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
    private String userName;
    private Integer petId ;
    private String petName;
    private String status;
}
