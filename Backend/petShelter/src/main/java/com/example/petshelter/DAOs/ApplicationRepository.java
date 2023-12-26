package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Application;
import com.example.petshelter.Models.ApplicationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, ApplicationId> {


}