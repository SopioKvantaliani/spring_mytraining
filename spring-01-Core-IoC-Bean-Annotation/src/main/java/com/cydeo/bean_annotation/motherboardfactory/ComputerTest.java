package com.cydeo.bean_annotation.motherboardfactory;

import com.cydeo.bean_annotation.Config.ComputerConfig;
import com.cydeo.loosely_coupled.PC;
import com.cydeo.loosely_coupled.casefactory.Case;
import com.cydeo.loosely_coupled.monitorfactory.Monitor;
import com.cydeo.loosely_coupled.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class);
        //AnnotationConfigApplicationContext Constructor accepts only class
        //after class we can use comma and add another configuration class and so on;
        //What happens behind the scene when we run app:
        //1.intellij will read .class parameter, 2.it will go that class, 3.checks all the @Bean methods and creates object.

        Monitor theMonitor = container.getBean(Monitor.class);
        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

        PC myPc = new PC(theCase,theMonitor, theMotherboard);
        myPc.powerUp();

    }
}
