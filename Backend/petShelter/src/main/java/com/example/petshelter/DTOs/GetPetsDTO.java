package com.example.petshelter.DTOs;

import com.example.petshelter.Services.Shelter.Filters.RelationList;

import java.util.List;

public class GetPetsDTO {
    public int pageNo ;
    public List<RelationList> criteria;

}
