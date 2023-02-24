package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.config.PcConfig;
import com.cydeo.streotype_annotation.monitorfactory.AcerMonitor;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

         //Container is created, go to Config class, whenever you find component annotation create object and manage.
        ApplicationContext container = new AnnotationConfigApplicationContext(PcConfig.class);

        Monitor theMonitor = container.getBean(Monitor.class);
        System.out.println(theMonitor.getSize());

        Monitor theMonitor2 = container.getBean(AcerMonitor.class); //Default Name ClassName;
        System.out.println(theMonitor2.getModel());







    }


}
