package com.cydeo.bootstrap;

import com.cydeo.entity.Car;
import com.cydeo.entity.Department;
import com.cydeo.entity.Employees;
import com.cydeo.enums.Gender;
import com.cydeo.repository.CarRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {


    private final CarRepository carRepository;
    private final EmployeesRepository employeesRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(CarRepository carRepository, EmployeesRepository employeesRepository, DepartmentRepository departmentRepository) {
        this.carRepository = carRepository;
        this.employeesRepository = employeesRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car c1 = new Car("BMW", "M3");
        Car c2 = new Car("Honda", "Civic");
        Car c3 = new Car("Toyota", "Corolla");

        //now how to save the objects to DB?
        //do we have any method which is doing this saving for me??
        //yes we have "save" method which comes from repository

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

        List<Employees> employeeList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();


        Employees e1 = new Employees("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20), Gender.FEMALE, 2500);
        Employees e2 = new Employees("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26),Gender.FEMALE, 2500);
        Employees e3 = new Employees("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17), Gender.FEMALE, 2500);
        Employees e4 = new Employees("Avrom", "Rowantree", null, LocalDate.of(2014,03,02), Gender.MALE, 2500);
        Employees e5 = new Employees("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), Gender.MALE, 2500);

        Department d1 = new Department("Sports", "Outdoors");
        Department d2 = new Department("Tools", "Hardware");
        Department d3 = new Department("Clothing", "Home");
        Department d4 = new Department("Phones & Tablets", "Electronics");
        Department d5 = new Department("Computers", "Electronics");

        //addAll method comes from repository interface
        employeeList.addAll(Arrays.asList(e1, e2, e3, e4, e5));
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeesRepository.saveAll(employeeList);
        departmentRepository.saveAll(departmentList);


    }
}
//we implement interface CommandLIneRunner, because it provides run method, that we need to create objects;
//in order to use any method that belongs to different class, we need to inject Dependency;