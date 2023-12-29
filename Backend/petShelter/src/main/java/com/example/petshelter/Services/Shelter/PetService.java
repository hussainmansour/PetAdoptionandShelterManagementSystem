package com.example.petshelter.Services.Shelter;

import com.example.petshelter.Models.Pet;

import java.util.List;

public interface PetService {
    public List<Pet> getAllPets();

    public void insertPet(Pet pet);

    public List<Pet> searchByShelter(String shelterName);

    public List<Pet> searchBySpecies(String species);

    public List<Pet> searchByBreed(String breed);


    public List<Pet> searchByAge(String age);


    public List<Pet> searchByLocation(String location);

    public void adoptPet(Pet pet);




}
