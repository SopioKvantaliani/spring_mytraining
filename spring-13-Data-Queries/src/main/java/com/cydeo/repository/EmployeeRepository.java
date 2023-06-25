package com.cydeo.repository;

import com.cydeo.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

    //Display all employees with email address "..."
    List <Employee> findByEmail(String email);

    //Display all employees with firstName "" and last name""
    //also show all employees with and emails address;

    List <Employee> findByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCaseOrEmailContains(String firstName, String LastName, String email);
    List<Employee> findByFirstNameAndLastNameOrEmail (String firstName, String LastName, String email);

    //Display all employees that first name is not "   "
    List<Employee> findByFirstNameIsNot (String firstName);

    //Display all employees where lastName starts with ""
    List<Employee>  findByLastNameStartingWith (String pattern);

    //Display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan (Integer salary);

    //Display all employees with salaries less than ""
    List<Employee> findBySalaryLessThan (Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees

    //?????????

    //Display all employees where salaries greater and equal to "" in order salary
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findAllByEmailIsNull();
    List<Employee> findAllByEmailIsNot(String email); //Double check if that is correct;

    //-----------------------------------------------JPQL----------------------------------------

    @Query("SELECT employee FROM Employee employee WHERE employee.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query ("select e.salary from Employee e Where e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

    //Not Equal
    @Query ("SELECT e from Employee e where e.salary <> ?1  ") // <> in sql mean "!="
    List<Employee> retrieveEmployeeSalaryNotEqual (int salary);

    //Like / Contain / StartsWith / EndWith
    @Query ("select e From Employee e Where e.firstName like  ?1")
    List<Employee> retrieveEmployeeFirstNameLike (String pattern);

    //Less Than
    @Query ("select e from Employee e where e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan (int salary);

    //Greater Than
    @Query ("select e from Employee  e where e.salary> ?1")
    List<Employee> retrieveEmployeeSalaryGreaterThan (int salary);

    //Display all firstNames where salary is greater than...
    @Query ("select e.firstName from Employee  e where e.salary> ?1")
    List<String> retrieveEmployeeFirstNameSalaryGreaterThan (int salary); //as we retrieve names here we changed return time as String;

    //Between
    @Query ("select e from Employee  e where e.salary between ?1 and ?2")
    List<Employee> retrieveEmployeeSalaryBetween (int salary1, int salary2);

    //Before
    @Query("select e from Employee e where e.hireDate < ?1")
    List <Employee> retrieveEmployeeHireDateBefore (LocalDate date);

    //NULL
    @Query ("select e from Employee e where e.email Is NULL ")
    List<Employee> retrieveEmployeeEmailIsNull ();

    //Not NUll
    @Query ("select e from Employee e where e.email Is Not NULL ")
    List<Employee> retrieveEmployeeEmailIsNotNull ();

    //Sorting in Asc Order
    @Query("select e from Employee  e order by e.salary asc ")
    List<Employee> retrieveEmployeeSalaryOrderAsc ();

    //Sorting in Asc Order
    @Query("select e from Employee  e order by e.salary desc ")
    List<Employee> retrieveEmployeeSalaryOrderDsc ();

    //------------------------------------------//Native Query//-------------------------------------------//
    @Query(value = "select * from employee where salary = ?1", nativeQuery = true)
    List <Employee> retrieveEmployeeDetailBySalary(int salary);
    //employees here is table name and should be matched with tables everything.
    //nativeQuery = true this should be added, its poor sql.

    //Name Parameter
    @Query("select e from Employee  e where e.salary = :salary") //we use column and parameter name
    List <Employee> retrieveEmployeeSalary (@Param("salary") int salary); //to catch salary that assign to method "salary" we need to use @Param




}
