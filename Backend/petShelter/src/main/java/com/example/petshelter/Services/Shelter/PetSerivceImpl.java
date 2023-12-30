package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.BreedRelationRepository;
import com.example.petshelter.DAOs.PetRepository;
import com.example.petshelter.DAOs.ShelterRepository;
import com.example.petshelter.DTOs.*;
import com.example.petshelter.Models.Application;
import com.example.petshelter.Models.BreedRelation;
import com.example.petshelter.Models.Document;
import com.example.petshelter.Models.Pet;
import com.example.petshelter.Services.Shelter.Filters.FilterCriteria;
import com.example.petshelter.Services.Shelter.Filters.FilterFactory;
import com.example.petshelter.Services.Shelter.Filters.FilterTypes;
import com.example.petshelter.Services.Shelter.Filters.RelationList;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NonNullApi
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
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("id") , -1));
    }
    private Specification<Pet> getSpecification(List<RelationList> criteria){
        Specification<Pet> pets = getAllSpecification();

        for(RelationList c : criteria){
            FilterCriteria filterCriteria = filterFactory.getFilterCriteria(c);
            pets = pets.and(filterCriteria.meetCriteria());
        }
        return pets;
    }
    public ResponseEntity<Page<SearchPetDTO>> getAllPets(GetPetsDTO getPetsDTO){
        try {
            Pageable pageable = PageRequest.of(getPetsDTO.getPageNo(), 10);
            Page<Pet> petsPage =  petRepository.findAll( getSpecification(getPetsDTO.getCriteria()) , pageable);
            if (petsPage.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            Page<SearchPetDTO>  searchPetDTOPage = new PageImpl<>(
                    petsPage.getContent().stream()
                            .map(user -> SearchPetDTO.builder()
                                    .date(user.getDateOfBirth().toString())
                                    .petId(user.getId())
                                    .name(user.getName())
                                    .shelterName(user.getShelterName().getName())
                                    .gender(user.getGender())
                                    .build())
                            .toList(),
                    pageable, petsPage.getTotalElements()
            );
            return ResponseEntity.ok(searchPetDTOPage);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }


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


    public ProfileDTO getProfile(Integer petId){
        Pet pet = petRepository.findById(petId).orElseThrow();

        ProfileDTO profileDTO = ProfileDTO.builder()
                .id(petId)
                .breed(pet.getBreed().getBreedId())
                .species(pet.getBreed().getSpecies())
                .behaviour(pet.getBehaviour())
                .name(pet.getName())
                .gender(pet.getGender())
                .dateOfBirth(pet.getDateOfBirth())
                .description(pet.getDescription())
                .isAdopted(pet.getIsAdopted())
                .applications(mapperApplication(new ArrayList<>( pet.getApplications())))
                .documents(mapperDocument(new ArrayList<>(pet.getDocuments())))
                .shelterName(pet.getShelterName().getName())
                .healthStatus(pet.getHealthStatus())
                .build();

        return profileDTO;

    }

    private List<ApplicationDTO> mapperApplication(List<Application> result){
        List< ApplicationDTO> dto = new ArrayList<>();
        for(Application application: result ){
            ApplicationDTO applicationDTO = ApplicationDTO.builder()
                    .petName(application.getPet().getName())
                    .petId(application.getPet().getId())
                    .userName(application.getAdopterUsername().getAdopterUsername())
                    .status(application.getStatus())
                    .build();
            dto.add(applicationDTO);
        }
        return dto;
    }

    private List<DocumentDTO> mapperDocument(List<Document> result){

        List< DocumentDTO> dto = new ArrayList<>();
        for(Document application: result ){
            DocumentDTO applicationDTO = DocumentDTO.builder()
                    .petId(application.getPet().getId())
                    .file(application.getFile())
                    .type(application.getType())
                    .build();
            dto.add(applicationDTO);
        }
        return dto;
    }

}
