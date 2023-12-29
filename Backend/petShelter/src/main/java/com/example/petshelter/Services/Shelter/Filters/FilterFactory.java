package com.example.petshelter.Services.Shelter.Filters;

import org.springframework.stereotype.Component;

@Component
public class FilterFactory {

    public FilterCriteria getFilterCriteria(RelationList relationList){
        return switch (relationList.first){
            case "isAdopted" ->  new AvailableCriteria((Boolean) relationList.second);
            case "location" -> new locationCriteria((String) relationList.second);
            case "gender" -> new GenderCriteria((String) relationList.second);
            case "shelterName" -> new ShelterCriteria((String) relationList.second);
            case "name" -> new NameCriteria((String) relationList.second);
            default -> throw new IllegalStateException("Unexpected value: " + relationList.first);
        };

    }
}
