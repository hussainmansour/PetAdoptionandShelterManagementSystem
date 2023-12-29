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
@Table(name = "adopter")
public class Adopter implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(SystemRoles.ADOPTER.name()));
    }

    @Override
    public String getUsername() {
        return  this.adopterUsername;
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