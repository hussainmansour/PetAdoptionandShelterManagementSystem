package com.example.petshelter.Services.Shelter;

import com.example.petshelter.DAOs.ManagerRepository;
import com.example.petshelter.DAOs.ShelterRepository;
import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;
import com.example.petshelter.Services.Shelter.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShelterServiceImpl implements ShelterService {

    @Autowired
    private ShelterRepository shelterRepository;

    @Autowired
    private ManagerRepository managerRepository;
    @Override
    public List<Shelter> getAllShelter() {
        List<Shelter> all = shelterRepository.findAll();
        return all;
    }

    @Override
    public ResponseEntity insertShelter(Shelter shelter) {
        shelterRepository.save(shelter);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @Override
    public List<Shelter> getManagerShelters(String managerUserName) {
        Manager manager = (Manager) managerRepository.findAllById(Collections.singleton(managerUserName));
        return shelterRepository.findByManagerUsername(manager);
    }
}

