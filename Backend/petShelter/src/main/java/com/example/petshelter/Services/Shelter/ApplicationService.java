package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DTOs.ApplicationDTO;
import com.example.petshelter.DTOs.InsertApplicationDTO;
import com.example.petshelter.DTOs.UpdateApplicationDTO;
import com.example.petshelter.Models.Application;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ApplicationService {
    public List<ApplicationDTO> getAllApplication();
    public List<ApplicationDTO> getPetApplication(Integer petId);
    public List<ApplicationDTO> getPendingApplication(String shelterName);
    public List<ApplicationDTO> getAdopterApplication(String adopterUserName);
    public List<ApplicationDTO> getAcceptedApplication(String adopterUserName);

    public List<ApplicationDTO> getAcceptedOrRefusedApplication(String adopterUserName);

    public String insertApplication(InsertApplicationDTO insertApplicationDTO);

    public String updateApplication(UpdateApplicationDTO updateApplicationDTO);

}
