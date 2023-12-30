package com.example.petshelter.Controllers;

import com.example.petshelter.DTOs.ApplicationDTO;
import com.example.petshelter.Utilities.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ControllerAdvice
@RequestMapping("/database")
public class DatabaseController {

    @GetMapping("/backup")
    public ResponseEntity<Boolean> backupDatabase() {
        return ResponseEntity.ok(Database.Backup());
    }

    @GetMapping("/restore")
    public ResponseEntity<Boolean> restoreDatabase() {
        return ResponseEntity.ok(Database.RestoreDB());
    }

}
