package com.example.petshelter.Services.Shelter.Filters;

import com.example.petshelter.Models.Pet;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
@AllArgsConstructor
public class ShelterCriteria implements FilterCriteria{
    private String ShelterName;


    @Override
    public Specification<Pet> meetCriteria() {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("Shelter_name"), "%" + ShelterName + "%");


    }
}
