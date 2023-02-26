package com.cydeo;

import com.cydeo.bean_practice.FullTimeEmployee;
import com.cydeo.bean_practice.PartTimeEmployee;
import com.cydeo.configPackage.Config2;
import com.cydeo.configPackage.ConfigClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigClass.class, Config2.class);
        FullTimeEmployee ft = container.getBean(FullTimeEmployee.class);
        ft.createAccount();
        PartTimeEmployee pt = container.getBean(PartTimeEmployee.class);
        pt.createAccount();

        String str1 = container.getBean("welcome", String.class);
        String str2 = container.getBean("practice", String.class);

        System.out.println(str1);



    }
}
