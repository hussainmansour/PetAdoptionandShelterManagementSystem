package com.example.petshelter.Services.Shelter.Filters;

import com.example.petshelter.Models.Pet;
import org.springframework.data.jpa.domain.Specification;

public interface FilterCriteria {

    public Specification<Pet> meetCriteria();
}
