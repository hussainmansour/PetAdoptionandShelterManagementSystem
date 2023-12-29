package com.example.petshelter.Models;

import com.example.petshelter.Enums.SystemRoles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manager")
public class Manager implements UserDetails {
    @Id
    @Size(max = 45)
    @Column(name = "manager_username", nullable = false, length = 45)
    private String managerUsername;

    @Size(max = 20)
    @Column(name = "contact_no", length = 20)
    private String contactNo;

    @Size(max = 45)
    @NotNull
    @Column(name = "fname", nullable = false, length = 45)
    private String fname;

    @Size(max = 45)
    @Column(name = "lname", length = 45)
    private String lname;

    @Size(max = 45)
    @NotNull
    @Column(name = "password", nullable = false, length = 45)
    private String password;

//    @OneToMany(mappedBy = "managerUsername")
//    private Set<Shelter> shelters = new LinkedHashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(SystemRoles.MANAGER.name()));
     }

    @Override
    public String getUsername() {
        return  this.managerUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}