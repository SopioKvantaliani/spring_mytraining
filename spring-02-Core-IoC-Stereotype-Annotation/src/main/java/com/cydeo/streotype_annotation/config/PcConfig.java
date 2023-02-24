package com.cydeo.streotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan ("com.cydeo") //give annotation with package name from Spring takes responsibility of creating objects.
public class PcConfig {

}
