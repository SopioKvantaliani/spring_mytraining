package com.cydeo.bean_annotation.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    public String str (){
        return "Cydeo";
    }
    @Bean
    public Integer number (){
        return 10;
    }

    @Bean
    public String str2 (){
        return new String();
    }


}

//First step create configuration class and annotate with @Configuration
//Second Step create method and return object; Annotate that class with @Bean
