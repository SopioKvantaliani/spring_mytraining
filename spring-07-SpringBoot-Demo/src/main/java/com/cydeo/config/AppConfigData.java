package com.cydeo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
public class AppConfigData {

    @Value("${username}")  //this annotation brings properties from application.properties
    private String userName;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;
}
