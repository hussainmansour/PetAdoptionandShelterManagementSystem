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
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staff")
public class Staff implements UserDetails {
    @Id
    @Size(max = 45)
    @Column(name = "staff_username", nullable = false, length = 45)
    private String staffUsername;

    @Size(max = 20)
    @Column(name = "contact_no", length = 20)
    private String contactNo;

    @NotNull
    @Lob
    @Column(name = "role", nullable = false)
    private String role;

    @Size(max = 45)
    @NotNull
    @Column(name = "fname", nullable = false, length = 45)
    private String fname;

    @Size(max = 45)
    @Column(name = "lname", length = 45)
    private String lname;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shelter_name", nullable = false)
    private Shelter shelterName;

    @Size(max = 80)
    @NotNull
    @Column(name = "password", nullable = false, length = 80)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(SystemRoles.STAFF.name()));
    }

    @Override
    public String getUsername() {
        return this.staffUsername;
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