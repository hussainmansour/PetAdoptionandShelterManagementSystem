package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.BreedRelationRepository;
import com.example.petshelter.DAOs.PetRepository;
import com.example.petshelter.DAOs.ShelterRepository;
import com.example.petshelter.DTOs.GetPetsDTO;
import com.example.petshelter.DTOs.PetDTO;
import com.example.petshelter.Models.BreedRelation;
import com.example.petshelter.Models.Pet;
import com.example.petshelter.Services.Shelter.Filters.FilterCriteria;
import com.example.petshelter.Services.Shelter.Filters.FilterFactory;
import com.example.petshelter.Services.Shelter.Filters.FilterTypes;
import com.example.petshelter.Services.Shelter.Filters.RelationList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class PetSerivceImpl implements PetService{



    @Autowired
    private PetRepository petRepository;

    @Autowired
    private BreedRelationRepository breedRelationRepository;
    @Autowired
    private ShelterRepository shelterRepository;
    @Autowired
    private FilterFactory filterFactory;

    public List<Pet> searchBySpecies(String species) {
        return petRepository.searchBySpecies(species);
    }

    public List<Pet> searchByBreed(String breed) {
        return petRepository.searchByBreed(breed);
    }

//    public List<Pet> searchByAge(Integer age) {
//        return petRepository.searchByAge(age);
//    }

    public List<Pet> searchByLocation(String location) {
        return petRepository.searchByShelterLocation(location);
    }

    private Specification<Pet> getAllSpecification(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("pet_id") , -1));
    }
    private Specification<Pet> getSpecification(List<RelationList> criteria){
        Specification<Pet> pets = getAllSpecification();
        for(RelationList c : criteria){
            FilterCriteria filterCriteria = filterFactory.getFilterCriteria(c);
            pets = pets.and(filterCriteria.meetCriteria());
        }
        return pets;

    }
    public ResponseEntity<Page<Pet>> getAllPets(GetPetsDTO getPetsDTO){


        Pageable pageable = (Pageable) PageRequest.of(getPetsDTO.pageNo,10 );
        Page<Pet> petsPage = (Page<Pet>) petRepository.findAll( getSpecification(getPetsDTO.criteria));

        if (petsPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(petsPage);

    }

    public ResponseEntity<Page<Pet>> getAllNonAdoptedPets(int pageNo ){
        Pageable pageable = (Pageable) PageRequest.of(pageNo,10 );
        Page<Pet> petsPage = (Page<Pet>) petRepository.findAllNonAdoptedPets();

        if (petsPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(petsPage);
    }

    public void insertPet(PetDTO pet){
        BreedRelation breedRelation = BreedRelation.builder()
                .breedId(pet.getBreed())
                .species(pet.getSpecies())
                .build();
        if(breedRelationRepository.findById(pet.getBreed()).isEmpty()){
            breedRelationRepository.save(breedRelation);
        }
        System.out.println("fdsf");
        Pet pet1 = Pet.builder()
                .behaviour(pet.getBehaviour())
                .dateOfBirth(pet.getDateOfBirth())
                .description(pet.getDescription())
                .gender(pet.getGender())
                .healthStatus(pet.getHealthStatus())
                .shelterName(shelterRepository.findById(pet.getShelterName()).orElseThrow())
                .name(pet.getName())
                .breed(breedRelationRepository.findById(pet.getBreed()).orElseThrow())
                .isAdopted(false)
                .build();

        petRepository.save(pet1);
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
