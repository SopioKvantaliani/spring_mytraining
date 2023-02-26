package com.cydeo.service;

import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.HoursRepositoryInterface;
import com.cydeo.repository.RegularHours;
import org.springframework.stereotype.Component;

@Component
public class SalaryService {
EmployeeRepository employeeRepository;
HoursRepositoryInterface hoursRepositoryInterface;

    public SalaryService(EmployeeRepository employeeRepository, HoursRepositoryInterface hoursRepositoryInterface) {
        this.employeeRepository = employeeRepository;
        this.hoursRepositoryInterface = hoursRepositoryInterface;
    }

    public void calculateRegularSalary (){
        System.out.println(employeeRepository.getHourlyRate()* hoursRepositoryInterface.getHours());
    }
}
