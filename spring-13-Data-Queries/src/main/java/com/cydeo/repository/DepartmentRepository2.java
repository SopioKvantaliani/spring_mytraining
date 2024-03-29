package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository2 extends JpaRepository <Department, String> {//String because "department" is primary key

    //Display all departments in the furniture Department
    List<Department> findByDepartment(String department);

    //Display all departments in the Health Division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals (String division);

    //Display all departments with Division name ends with 'ics'
    List<Department> findByDivisionEndingWith(String pattern);

    //Display top 3 departments with division name includes "Hea" Without duplicates
    List <Department> findDistinctTop3ByDivisionContaining(String pattern);

    @Query ("select d from Department d where d.division IN ?1") //IN is poor sql
    List <Department> retrieveDepartmentDivision (List <String> division); //it retrieves many divisions and we use List





}
