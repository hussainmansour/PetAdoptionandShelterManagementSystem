package com.example.petshelter.DAOs;

import com.example.petshelter.Models.Document;
import com.example.petshelter.Models.DocumentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, DocumentId> {
}