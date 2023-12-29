package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Adopter;
import com.example.petshelter.Models.Application;
import com.example.petshelter.Models.ApplicationId;
import com.example.petshelter.Models.Pet;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, ApplicationId> {
    @Query("SELECT a FROM Application a WHERE a.status IN ('Accepted', 'Refused') ORDER BY a.date")
    List<Application> findAllAcceptedOrRefusedApplicationsOrderByDate();


    @Query("SELECT a FROM Application a WHERE a.pet.id = :petId")
    List<Application> findApplicationsByPet(@Param("petId") Integer petId);

    @Query("SELECT a FROM Application a WHERE a.adopterUsername.adopterUsername = :adopterId")
    List<Application> findApplicationsByAdopter(@Param("adopterId") String adopterId);


    @Query("SELECT a FROM Application a " +
            "WHERE a.adopterUsername.adopterUsername = :adopterId " +
            "AND a.pet.id = :petId")
    List <Application> findApplicationsByPetAndAdopter(@Param("adopterId") String adopterId ,@Param("petId") Integer petId );





}