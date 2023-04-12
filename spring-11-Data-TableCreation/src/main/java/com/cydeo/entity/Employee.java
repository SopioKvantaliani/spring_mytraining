package com.cydeo.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity // this annotation creates table in the DataBase. We tell spring to create table
public class Employee {

    @Id //identify as a primary key
    private int id;
    private String name;

}
