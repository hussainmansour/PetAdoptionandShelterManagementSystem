package com.example.petshelter.Database;

import com.example.petshelter.Utilities.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class DatabaseTest {

    @Test
    public void testBackup(){
        assertTrue(Database.Backup());
    }

    @Test
    public void testRestore(){
        assertTrue(Database.RestoreDB());
    }
}
