package com.example.petshelter.Services.Shelter.Filters;

import com.example.petshelter.Models.Pet;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
@AllArgsConstructor
public class GenderCriteria implements FilterCriteria {

    private String gender;


    @Override
    public Specification<Pet> meetCriteria() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("gender"), "%" + gender + "%");
    }
}
