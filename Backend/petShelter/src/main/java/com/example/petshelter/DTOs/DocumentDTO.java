package com.example.petshelter.DTOs;

import com.example.petshelter.Models.Pet;
import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private Integer petId;
    private String file;
    private String type;
}
