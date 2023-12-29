package com.example.petshelter.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ApplicationId implements Serializable {
    private static final long serialVersionUID = -52162079131929018L;
    @NotNull
    @Column(name = "pet_id", nullable = false)
    private Integer petId;

    @Size(max = 45)
    @NotNull
    @Column(name = "adopter_username", nullable = false, length = 45)
    private String adopterUsername;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ApplicationId entity = (ApplicationId) o;
        return Objects.equals(this.petId, entity.petId) &&
                Objects.equals(this.adopterUsername, entity.adopterUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, adopterUsername);
    }

}