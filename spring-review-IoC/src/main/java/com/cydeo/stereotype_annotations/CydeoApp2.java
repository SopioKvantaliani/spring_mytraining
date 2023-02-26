package com.cydeo.stereotype_annotations;

import com.cydeo.stereotype_annotations.config.Config;
import com.cydeo.stereotype_annotations.model.DataStructure;
import com.cydeo.stereotype_annotations.model.ExtraHours;
import com.cydeo.stereotype_annotations.model.Microservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp2 {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

         DataStructure dataStructure = container.getBean(DataStructure.class);
         Microservice microservice = container.getBean(Microservice.class);
         ExtraHours extraHours = container.getBean(ExtraHours.class);


          System.out.println(extraHours.getHours());





    }
}
