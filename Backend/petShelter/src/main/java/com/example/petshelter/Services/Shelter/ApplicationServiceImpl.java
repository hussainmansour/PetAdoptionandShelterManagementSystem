package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.AdopterRepository;
import com.example.petshelter.DAOs.ApplicationRepository;
import com.example.petshelter.DAOs.PetRepository;
import com.example.petshelter.DTOs.ApplicationDTO;
import com.example.petshelter.DTOs.InsertApplicationDTO;
import com.example.petshelter.DTOs.UpdateApplicationDTO;
import com.example.petshelter.Models.Adopter;
import com.example.petshelter.Models.Application;
import com.example.petshelter.Models.ApplicationId;
import com.example.petshelter.Models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ApplicationDTO> getAllApplication(){

        List<Application> result =  applicationRepository.findAll();
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
    public List<ApplicationDTO> getPetApplication(Integer petId){
        List<Application> result =  applicationRepository.findApplicationsByPet(petId);

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

    public List<ApplicationDTO> getAdopterApplication(String adopterUserName){
        List<Application> result =  applicationRepository.findApplicationsByAdopter(adopterUserName);
        List< ApplicationDTO> dto = new ArrayList<>();
        for(Application application: result ){
            ApplicationDTO applicationDTO = ApplicationDTO.builder()
                    .petName(application.getPet().getName())
                    .petId(application.getPet().getId())
                    .userName(adopterUserName)
                    .status(application.getStatus())
                    .build();
            dto.add(applicationDTO);
        }
        return dto;
    }
    public List<ApplicationDTO> getAcceptedApplication(String adopterUserName){
        List<Application> result =  applicationRepository.findAllAcceptedOrRefusedApplicationsOrderByDate(adopterUserName);

        List< ApplicationDTO> dto = new ArrayList<>();
        for(Application application: result ){
            ApplicationDTO applicationDTO = ApplicationDTO.builder()
                    .petName(application.getPet().getName())
                    .petId(application.getPet().getId())
                    .userName(adopterUserName)
                    .status(application.getStatus())
                    .build();
            dto.add(applicationDTO);
        }
        return dto;
    }

    public List<ApplicationDTO> getPendingApplication(String shelterName){
        List<Application> result =  applicationRepository.findAllPendingApplicationsOrderByDate(shelterName);

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


    public List<ApplicationDTO> getAcceptedOrRefusedApplication(String adopterUserName){
        List<Application> result = applicationRepository.findAllAcceptedOrRefusedApplicationsOrderByDate(adopterUserName);

        List< ApplicationDTO> dto = new ArrayList<>();
        for(Application application: result ){
            ApplicationDTO applicationDTO = ApplicationDTO.builder()
                    .petName(application.getPet().getName())
                    .petId(application.getPet().getId())
                    .userName(adopterUserName)
                    .status(application.getStatus())
                    .build();
            dto.add(applicationDTO);
        }
        return dto;
    }


    public String insertApplication(InsertApplicationDTO insertApplicationDTO){
        if(!applicationRepository.findApplicationsByPetAndAdopter(insertApplicationDTO.userName , insertApplicationDTO.petId).isEmpty()){
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
        if(!app.get(0).getStatus().equals("Pending")){
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
