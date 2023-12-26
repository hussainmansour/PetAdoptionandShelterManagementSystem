package com.example.petshelter.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "adopter")
public class Adopter {
    @Id
    @Size(max = 45)
    @Column(name = "adopter_username", nullable = false, length = 45)
    private String adopterUsername;

    @Size(max = 20)
    @Column(name = "contact_no", length = 20)
    private String contactNo;

    @Size(max = 45)
    @Column(name = "fname", length = 45)
    private String fname;

    @Size(max = 45)
    @Column(name = "lname", length = 45)
    private String lname;

    @Size(max = 45)
    @NotNull
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @OneToMany(mappedBy = "adopterUsername")
    private Set<Application> applications = new LinkedHashSet<>();

    @OneToMany(mappedBy = "adopterUsername")
    private Set<PrivateNotification> privateNotifications = new LinkedHashSet<>();

}