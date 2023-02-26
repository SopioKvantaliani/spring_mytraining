package com.cydeo.configPackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
@Configuration
public class Config2 {
    @Bean (name = "welcome")
//   that print only one object
    public String printString (){
        return "Welcome CydeoApp";

    }
    @Bean (name = "practice")
    public String printString2 (){
        return "Spring Core Practice";
    }
}
