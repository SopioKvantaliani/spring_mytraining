package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.DellCase;
import com.cydeo.streotype_annotation.config.PcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container =new AnnotationConfigApplicationContext(PcConfig.class);

        PC myPc = container.getBean(PC.class);
        DellCase dellCase = container.getBean(DellCase.class);


        System.out.println(dellCase.getModel());

        System.out.println(myPc.getTheCase().getDimensions().getDepth());
        System.out.println(myPc.getMonitor().getManufacturer());
    }
}
