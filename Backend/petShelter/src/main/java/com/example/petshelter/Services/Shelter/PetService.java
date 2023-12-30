package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DTOs.GetPetsDTO;
import com.example.petshelter.DTOs.PetDTO;
import com.example.petshelter.DTOs.ProfileDTO;
import com.example.petshelter.DTOs.SearchPetDTO;
import com.example.petshelter.Models.Pet;
import com.example.petshelter.Services.Shelter.Filters.RelationList;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PetService {

    public ResponseEntity<Page<SearchPetDTO>> getAllPets(GetPetsDTO getPetsDTO);
    public ResponseEntity<Page<Pet>> getAllNonAdoptedPets(int pageNo );

    public void insertPet(PetDTO pet);

    public List<Pet> searchByShelter(String shelterName);

    public List<Pet> searchBySpecies(String species);

    public List<Pet> searchByBreed(String breed);


//    public List<Pet> searchByAge(Integer age);


    public List<Pet> searchByLocation(String location);

    public void adoptPet(Pet pet);

    public ProfileDTO getProfile(Integer petId);




}
