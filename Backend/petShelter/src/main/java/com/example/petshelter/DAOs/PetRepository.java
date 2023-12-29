package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Pet;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> , JpaSpecificationExecutor<Pet> {

    @Query("SELECT p FROM Pet p WHERE p.shelterName = :shelterName")
    List<Pet> searchByShelter(@Param("shelterName") String shelterName);


    @Query("SELECT p FROM Pet p WHERE p.breed.species = :species")
    List<Pet> searchBySpecies(@Param("species") String species);

    @Query("SELECT p FROM Pet p WHERE p.breed.breedId = :breed")
    List<Pet> searchByBreed(@Param("breed") String breed);


//    @Query("SELECT p FROM Pet p WHERE FUNC('DATEDIFF', CURRENT_DATE, p.dateOfBirth) / 365 >= :age")
//    List<Pet> searchByAge(@Param("age") Integer age);


    @Query("SELECT p FROM Pet p WHERE p.shelterName.location = :shelterLocation")
    List<Pet> searchByShelterLocation(@Param("shelterLocation") String shelterLocation);

    @Query("SELECT p FROM Pet p WHERE p.isAdopted = false")
    List<Pet> findAllNonAdoptedPets();

    List<Pet> findAll(@Nullable Specification<Pet> specification);
}