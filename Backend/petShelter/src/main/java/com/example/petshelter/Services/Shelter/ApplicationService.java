package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DTOs.InsertApplicationDTO;
import com.example.petshelter.DTOs.UpdateApplicationDTO;
import com.example.petshelter.Models.Application;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ApplicationService {
    public List<Application> getAllApplication();
    public List<Application> getPetApplication(Integer petId);

    public List<Application> getAdopterApplication(String adopterUserName);
    public List<Application> getAcceptedApplication(String adopterUserName);

    public List<Application> getAcceptedOrRefusedApplication(String adopterUserName);

    public String insertApplication(InsertApplicationDTO insertApplicationDTO);

    public String updateApplication(UpdateApplicationDTO updateApplicationDTO);

}
