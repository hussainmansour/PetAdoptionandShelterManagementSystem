package com.example.petshelter.Controllers;

import com.example.petshelter.DTOs.GetPetsDTO;
import com.example.petshelter.Models.Pet;
import com.example.petshelter.Services.Shelter.PetService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/all")
    public ResponseEntity<Page<Pet>> getAllPets(@RequestBody GetPetsDTO getPetsDTO) {
        return petService.getAllPets(getPetsDTO);
    }

    @GetMapping("/non-adopted")
    public ResponseEntity<Page<Pet>> getAllNonAdoptedPets(@RequestParam int pageNo) {
        return petService.getAllNonAdoptedPets(pageNo);
    }

    @GetMapping("/search/species")
    public ResponseEntity<List<Pet>> searchBySpecies(@RequestParam String species) {
        List<Pet> pets = petService.searchBySpecies(species);
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/search/breed")
    public ResponseEntity<List<Pet>> searchByBreed(@RequestParam String breed) {
        List<Pet> pets = petService.searchByBreed(breed);
        return ResponseEntity.ok(pets);
    }

//    @GetMapping("/search/age")
//    public ResponseEntity<List<Pet>> searchByAge(@RequestParam Integer age) {
//        List<Pet> pets = petService.searchByAge(age);
//        return ResponseEntity.ok(pets);
//    }

    @GetMapping("/search/location")
    public ResponseEntity<List<Pet>> searchByLocation(@RequestParam String location) {
        List<Pet> pets = petService.searchByLocation(location);
        return ResponseEntity.ok(pets);
    }

    @PostMapping("/insert")
    public ResponseEntity<String> insertPet(@RequestBody Pet pet) {
        try {
            petService.insertPet(pet);
            return ResponseEntity.ok("Pet inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inserting pet");
        }
    }

    @PostMapping("/adopt")
    public ResponseEntity<String> adoptPet(@RequestBody Pet pet) {
        try {
            petService.adoptPet(pet);
            return ResponseEntity.ok("Pet adopted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adopting pet");
        }
    }

}