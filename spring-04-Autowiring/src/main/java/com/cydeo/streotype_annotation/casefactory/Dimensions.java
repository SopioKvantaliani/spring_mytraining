package com.cydeo.streotype_annotation.casefactory;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor
@Component
public class Dimensions {

    //Whenever I ask you inject this Dimension object to the container.

    private int width;
    private int height;
    private int depth;

    @Autowired
    public Dimensions() {
        this.width=10;
        this.height=30;
        this.depth=40;
    }

    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }
}
