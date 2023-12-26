package com.example.petshelter.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DocumentId implements Serializable {
    private static final long serialVersionUID = -978930903381294688L;
    @NotNull
    @Column(name = "document_id", nullable = false)
    private Integer documentId;

    @NotNull
    @Column(name = "pet_id", nullable = false)
    private Integer petId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DocumentId entity = (DocumentId) o;
        return Objects.equals(this.petId, entity.petId) &&
                Objects.equals(this.documentId, entity.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petId, documentId);
    }

}