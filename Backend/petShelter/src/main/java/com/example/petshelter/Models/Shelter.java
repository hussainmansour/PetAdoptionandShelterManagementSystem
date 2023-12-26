package com.example.petshelter.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shelter")
public class Shelter {
    @Id
    @Size(max = 45)
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Size(max = 20)
    @Column(name = "contact_no", length = 20)
    private String contactNo;

    @Size(max = 45)
    @NotNull
    @Column(name = "location", nullable = false, length = 45)
    private String location;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_username", nullable = false)
    private Manager managerUsername;

    @OneToMany(mappedBy = "shelterName")
    private Set<Pet> pets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "shelterName")
    private Set<Staff> staff = new LinkedHashSet<>();

}