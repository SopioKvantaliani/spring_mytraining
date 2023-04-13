package com.cydeo;

import com.cydeo.repository.DepartmentRepository2;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository2 departmentRepository2;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository2 departmentRepository2, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository2 = departmentRepository2;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------REGIONS------------------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountry: " + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountry: " + regionRepository.findByCountryContainingOrderByRegionDesc("United"));
        System.out.println("findByCountry: " + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findByCountry: " + regionRepository.findTopByCountryContainingOrderByRegion("United States"));

        System.out.println("--------------Departments------------------");

        System.out.println("Find All Departments" + " " + departmentRepository2.findByDepartment("Furniture"));
        System.out.println("Find All Departments" + " " + departmentRepository2.findByDivision("Health"));
        System.out.println("Find All Departments" + " " + departmentRepository2.findByDivisionEndingWith("ics"));
        System.out.println("Find All Departments" + " " + departmentRepository2.findDistinctTop3ByDivisionContaining("Health"));

        System.out.println("--------------Employees------------------");

        System.out.println("Find All Employees " + " " + employeeRepository.findByEmail("btrow5@technorati.com") );
        System.out.println("Find All Employees " + " " + employeeRepository.findByFirstNameAndLastNameOrEmail("Aeriell", "McNee", "btrow5@technorati.com") );



    }
}
