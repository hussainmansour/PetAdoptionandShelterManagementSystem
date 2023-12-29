package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Pet;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PetRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.petshelter.Models"})
@DataJpaTest
class PetRepositoryDiffblueTest {

//    @Autowired
//    private PetRepository petRepository;
//
//    /**
//     * Method under test: {@link PetRepository#searchByShelter(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchByShelter() {
//
//
//        String shelterName = "";
//        List<Pet> actualSearchByShelterResult = this.petRepository.searchByShelter(shelterName);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link PetRepository#searchBySpecies(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchBySpecies() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        String species = "";
//
//        // Act
//        List<Pet> actualSearchBySpeciesResult = this.petRepository.searchBySpecies(species);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link PetRepository#searchByBreed(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchByBreed() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        String breed = "";
//
//        // Act
//        List<Pet> actualSearchByBreedResult = this.petRepository.searchByBreed(breed);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link PetRepository#searchByAge(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchByAge() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException: Cannot invoke "Object.getClass()" because "obj" is null
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        String age = "";
//
//        // Act
//        List<Pet> actualSearchByAgeResult = this.petRepository.searchByAge(age);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
//
//    /**
//     * Method under test: {@link PetRepository#searchByShelterLocation(String)}
//     */
//    @Test
//    @Disabled("TODO: Complete this test")
//    void testSearchByShelterLocation() {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        // Arrange
//        // TODO: Populate arranged inputs
//        String shelterLocation = "";
//
//        // Act
//        List<Pet> actualSearchByShelterLocationResult = this.petRepository.searchByShelterLocation(shelterLocation);
//
//        // Assert
//        // TODO: Add assertions on result
//    }
}
