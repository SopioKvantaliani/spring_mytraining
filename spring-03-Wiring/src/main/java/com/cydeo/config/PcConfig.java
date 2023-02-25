package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import com.cydeo.monitorfactory.Monitor;
import com.cydeo.monitorfactory.SonyMonitor;
import com.cydeo.motherboardfactory.AsusMotherboard;
import com.cydeo.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PcConfig {
    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }

    @Bean
    public Case caseDell(Dimensions dimensions){ //There are 2 ways to pass the object to another object. 1. pass a method parameter, 2. set the object inside the method;

        return new DellCase("220B","Dell","240",dimensions);
        //If we provide dimension as a new object,that will be tightly coupled, and we don't want that.
    }


    @Bean
  public Monitor SonyMonitor (){
        return new SonyMonitor("Sony", "Sony1", 120);
  }

}
