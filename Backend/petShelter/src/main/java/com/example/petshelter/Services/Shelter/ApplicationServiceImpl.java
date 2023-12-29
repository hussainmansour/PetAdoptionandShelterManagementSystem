package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.AdopterRepository;
import com.example.petshelter.DAOs.ApplicationRepository;
import com.example.petshelter.DAOs.PetRepository;
import com.example.petshelter.DTOs.InsertApplicationDTO;
import com.example.petshelter.DTOs.UpdateApplicationDTO;
import com.example.petshelter.Models.Adopter;
import com.example.petshelter.Models.Application;
import com.example.petshelter.Models.ApplicationId;
import com.example.petshelter.Models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    PetRepository petRepository;

    @Autowired
    AdopterRepository adopterRepository;
    public List<Application> getAllApplication(){
        return applicationRepository.findAll();
    }
    public List<Application> getPetApplication(Integer petId){
        return applicationRepository.findApplicationsByPet(petId);
    }

    public List<Application> getAdopterApplication(String adopterUserName){
        return applicationRepository.findApplicationsByAdopter(adopterUserName);
    }
    public List<Application> getAcceptedApplication(String adopterUserName){
        return applicationRepository.findAllAcceptedOrRefusedApplicationsOrderByDate();
    }


    public List<Application> getAcceptedOrRefusedApplication(String adopterUserName){
        return applicationRepository.findAllAcceptedOrRefusedApplicationsOrderByDate();
    }


    public String insertApplication(InsertApplicationDTO insertApplicationDTO){
        if(applicationRepository.findApplicationsByPetAndAdopter(insertApplicationDTO.userName , insertApplicationDTO.petId) != null){
            return "Error the Application is already exists !! ";
        }

           Adopter adopter =  adopterRepository.findById(insertApplicationDTO.userName).orElseThrow();
           Pet pet =  petRepository.findById(insertApplicationDTO.petId).orElseThrow();
        ApplicationId applicationId = new ApplicationId();
        applicationId.setAdopterUsername(adopter.getAdopterUsername());
        applicationId.setPetId(pet.getId());

           Application application = new Application().builder()
                   .id(applicationId)
                   .pet(pet)
                   .adopterUsername(adopter)
                   .status("Pending")
                   .date(new Date())
                   .build();
           applicationRepository.save(application);
           return "Application Inserted successfully";
    }

    public String updateApplication(UpdateApplicationDTO updateApplicationDTO){
        List<Application> app  = applicationRepository.findApplicationsByPetAndAdopter(updateApplicationDTO.userName , updateApplicationDTO.petId);
        if(app.get(0).getStatus().equals("Pending")){
            return "can't update this Application";
        }

        app.get(0).setStatus(updateApplicationDTO.status);
        Pet pet = app.get(0).getPet();
        if(updateApplicationDTO.status.equals("Accepted")){
            pet.setIsAdopted(true);
            petRepository.save(pet);
        }
        app.get(0).setDate(new Date());
        applicationRepository.save(app.get(0));
        return "Applicatin is Updated";
    }

}
