package com.cydeo.repository;

import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Enumeration;

@Component
public class DBEmployeeRepository implements EmployeeRepository{


    //Assume we are getting this data from db
    @Override
    public int getHourlyRate() {
        Employee employee1 = new Employee("Sophie", "It", 55);
        return employee1.getHourlyRate();
    }

}
