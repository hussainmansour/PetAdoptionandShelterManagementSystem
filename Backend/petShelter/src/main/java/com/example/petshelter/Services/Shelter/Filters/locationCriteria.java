package com.example.petshelter.Services.Shelter.Filters;

import com.example.petshelter.Models.Pet;
import com.example.petshelter.Models.Shelter;
import jakarta.persistence.criteria.Join;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
@AllArgsConstructor
public class locationCriteria implements FilterCriteria{
    String location;


    @Override
    public Specification<Pet> meetCriteria() {
        return (root, query, criteriaBuilder) -> {
            Join<Pet, Shelter> authorsBook = root.join("shelter");
            return criteriaBuilder.like(root.get("location"), "%" + location + "%");
        };

    }
}
