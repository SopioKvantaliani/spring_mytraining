package com.cydeo.configPackage;

import com.cydeo.bean_practice.FullTimeEmployee;
import com.cydeo.bean_practice.PartTimeEmployee;
import com.sun.source.tree.BreakTree;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigClass {
    @Bean
    public FullTimeEmployee fullTimeEmployee (){
        return new FullTimeEmployee();
    }
    @Bean
    public PartTimeEmployee partTimeEmployee () {
        return new PartTimeEmployee();
    }


}
