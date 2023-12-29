package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.PetRepository;
import com.example.petshelter.Models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetSerivceImpl implements PetService{



    @Autowired
    private PetRepository petRepository;

    public List<Pet> searchBySpecies(String species) {
        return petRepository.searchBySpecies(species);
    }

    public List<Pet> searchByBreed(String breed) {
        return petRepository.searchByBreed(breed);
    }

    public List<Pet> searchByAge(String age) {
        return petRepository.searchByAge(String.valueOf(age));
    }

    public List<Pet> searchByLocation(String location) {
        return petRepository.searchByShelterLocation(location);
    }

    public List<Pet> getAllPets(){
        return petRepository.findAll();
    }

    public List<Pet> getAllNonAdoptedPets(){ return petRepository.findAllNonAdoptedPets();}

    public void insertPet(Pet pet){
        petRepository.save(pet);
    }

    public List<Pet> searchByShelter(String shelterName){
        return petRepository.searchByShelter(shelterName);
    }

    public void adoptPet(Pet pet){
        Optional<Pet> existingPetOptional = petRepository.findById(pet.getId());

        if (existingPetOptional.isPresent()) {
            Pet existingPet = existingPetOptional.get();
            existingPet.setIsAdopted(true);
            petRepository.save(existingPet);
        }
    }

}
