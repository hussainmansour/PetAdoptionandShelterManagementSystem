package com.example.petshelter.Services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.petshelter.DAOs.ShelterRepository;
import com.example.petshelter.Models.Manager;
import com.example.petshelter.Models.Shelter;

import java.util.ArrayList;
import java.util.List;

import com.example.petshelter.Services.Shelter.ShelterServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ShelterServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ShelterServiceImplDiffblueTest {
  @MockBean
  private ShelterRepository shelterRepository;

  @Autowired
  private ShelterServiceImpl shelterServiceImpl;

  /**
   * Method under test: {@link ShelterServiceImpl#getAllShelter()}
   */
  @Test
  void testGetAllShelter() {
    // Arrange
    ArrayList<Shelter> shelterList = new ArrayList<>();
    when(shelterRepository.findAll()).thenReturn(shelterList);

    // Act
    List<Shelter> actualAllShelter = shelterServiceImpl.getAllShelter();

    // Assert
    verify(shelterRepository).findAll();
    assertTrue(actualAllShelter.isEmpty());
    assertSame(shelterList, actualAllShelter);
  }

  /**
   * Method under test: {@link ShelterServiceImpl#insertShelter(Shelter)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testInsertShelter() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.ClassCastException: class org.springframework.http.ResponseEntity$DefaultBuilder cannot be cast to class org.springframework.http.ResponseEntity (org.springframework.http.ResponseEntity$DefaultBuilder and org.springframework.http.ResponseEntity are in unnamed module of loader com.diffblue.cover.g.g @45048695)
    //       at com.example.petshelter.Services.Shelter.ShelterServiceImpl.insertShelter(ShelterServiceImpl.java:27)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ShelterServiceImpl shelterServiceImpl = new ShelterServiceImpl();

    Manager managerUsername = new Manager();
    managerUsername.setContactNo("Contact No");
    managerUsername.setFname("Bella");
    managerUsername.setLname("Bella");
    managerUsername.setManagerUsername("janedoe");
    managerUsername.setPassword("iloveyou");

    Shelter shelter = new Shelter();
    shelter.setContactNo("Contact No");
    shelter.setLocation("Location");
    shelter.setManagerUsername(managerUsername);
    shelter.setName("Bella");

    // Act
    shelterServiceImpl.insertShelter(shelter);
  }

  /**
   * Method under test: {@link ShelterServiceImpl#getManagerShelters(Manager)}
   */
  @Test
  void testGetManagerShelters() {
    // Arrange
    ArrayList<Shelter> shelterList = new ArrayList<>();
    when(shelterRepository.findByManagerUsername(Mockito.<Manager>any())).thenReturn(shelterList);

    Manager manager = new Manager();
    manager.setContactNo("Contact No");
    manager.setFname("Bella");
    manager.setLname("Bella");
    manager.setManagerUsername("janedoe");
    manager.setPassword("iloveyou");

    // Act
    List<Shelter> actualManagerShelters = shelterServiceImpl.getManagerShelters(manager);

    // Assert
    verify(shelterRepository).findByManagerUsername(Mockito.<Manager>any());
    assertTrue(actualManagerShelters.isEmpty());
    assertSame(shelterList, actualManagerShelters);
  }
}
