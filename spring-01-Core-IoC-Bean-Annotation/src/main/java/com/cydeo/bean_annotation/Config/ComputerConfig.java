package com.cydeo.bean_annotation.Config;

import com.cydeo.loosely_coupled.casefactory.Case;
import com.cydeo.loosely_coupled.casefactory.DellCase;
import com.cydeo.loosely_coupled.monitorfactory.Monitor;
import com.cydeo.loosely_coupled.monitorfactory.SonyMonitor;
import com.cydeo.loosely_coupled.motherboardfactory.Motherboard;
import com.cydeo.loosely_coupled.motherboardfactory.AsusMotherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComputerConfig {

    @Bean
    public Monitor monitorSony (){
        return new SonyMonitor("25 inch Beast", "Acer", 25);  //Monitor abc = new SonyMonitor;
    }
    @Bean
    public Case caseDell () {
        return new DellCase("220B", "Dell", "240");
    }
   @Bean
    public Motherboard motherboardAsus() {
        return new AsusMotherboard ("BJ-200","Asus",4,6,"v2.44");

        }


}
