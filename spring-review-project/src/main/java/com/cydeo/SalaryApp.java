package com.cydeo;

import com.cydeo.config.Config;
import com.cydeo.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class SalaryApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);
        SalaryService salaryService = container.getBean(SalaryService.class);

        salaryService.calculateRegularSalary();




    }
}
