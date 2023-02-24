package com.cydeo.bean_annotation.motherboardfactory;

import com.cydeo.bean_annotation.Config.ComputerConfig;
import com.cydeo.loosely_coupled.PC;
import com.cydeo.loosely_coupled.casefactory.Case;
import com.cydeo.loosely_coupled.monitorfactory.AcerMonitor;
import com.cydeo.loosely_coupled.monitorfactory.Monitor;
import com.cydeo.loosely_coupled.monitorfactory.SonyMonitor;
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

        Monitor theMonitor = container.getBean(AcerMonitor.class);
//      SonyMonitor theMonitor2 = container.getBean(SonyMonitor.class);
        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

        PC myPc = new PC(theCase,theMonitor, theMotherboard); //here we pass objects we created above;
        myPc.powerUp();

        PC myPc2 = new PC(theCase,theMonitor,theMotherboard);

        System.out.println("-------------------------Multiple object------------------------------------");

        //How to retrieve objects when we have Multiple objects
         Monitor theMonitor2  = container.getBean("monitorSony", Monitor.class); //DEFAULT BEAN NAME
         Monitor theMonitor3  = container.getBean("sony", Monitor.class); //CUSTOM BEAN NAME
         Monitor theMonitor4  = container.getBean( Monitor.class); //@Primary annotation; Here we tell container "Monitor Type of Object"; Whenever we say primary it will give us that one;



    }
}
