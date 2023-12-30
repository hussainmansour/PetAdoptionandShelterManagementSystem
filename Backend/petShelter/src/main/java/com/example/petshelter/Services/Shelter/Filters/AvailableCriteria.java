package com.example.petshelter.Services.Shelter.Filters;

import com.example.petshelter.Models.Pet;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
public class AvailableCriteria implements FilterCriteria{
    private Boolean isAdopted;

    @Override
    public Specification<Pet> meetCriteria() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("isAdopted"), isAdopted);
    }
}
