package com.example.petshelter.DTOs;

import com.example.petshelter.Services.Shelter.Filters.RelationList;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPetsDTO {
    private int pageNo ;
    private List<RelationList> criteria;

}
