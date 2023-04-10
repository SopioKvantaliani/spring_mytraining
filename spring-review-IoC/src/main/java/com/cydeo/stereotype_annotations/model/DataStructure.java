package com.cydeo.stereotype_annotations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataStructure {

    private final ExtraHours extraHours;


    public void getTotalHours (){
        System.out.println("Total hours: "+(20+ extraHours.getHours()));
    }

}
