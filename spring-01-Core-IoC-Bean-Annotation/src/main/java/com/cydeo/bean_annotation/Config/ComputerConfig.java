package com.cydeo.bean_annotation.Config;

import com.cydeo.loosely_coupled.casefactory.Case;
import com.cydeo.loosely_coupled.casefactory.DellCase;
import com.cydeo.loosely_coupled.monitorfactory.AcerMonitor;
import com.cydeo.loosely_coupled.monitorfactory.Monitor;
import com.cydeo.loosely_coupled.monitorfactory.SonyMonitor;
import com.cydeo.loosely_coupled.motherboardfactory.Motherboard;
import com.cydeo.loosely_coupled.motherboardfactory.AsusMotherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {

    @Bean
    public Monitor monitorSony (){
        return new SonyMonitor("25 inch Beast", "Sony", 25);  //Monitor abc = new SonyMonitor;
    }
    @Bean
    @Primary //method name will be in default and there is no need to pass method name when creating object; example is in ComputerTest class
    public Monitor monitorAcer (){ //method name is default name of Bean
        return new AcerMonitor ("23 inch Beast", "Acer", 23);
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
