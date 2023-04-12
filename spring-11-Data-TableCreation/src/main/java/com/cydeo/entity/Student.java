package com.cydeo.entity;

import com.cydeo.enums.Gender;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table (name = "students") //rename the table name
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Postgres you create id for me
    private Long id;

    @Column(name = "studentFirstName") //change the column name annotation
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE") //when we work on date/time in the entity we need to add this definition.
    private LocalDate birthDate;
    @Column(columnDefinition = "Time") //this defines datatype, so we will have date/time format in database
    private LocalTime birthTime;
    @Column(columnDefinition = "TimeStamp")
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING) //Enum constant will be Female/Male as a String.
//    @Enumerated (EnumType.ORDINAL) //Enum constant will be 0, 1, 2 ...
    private Gender gender;

    @Transient //when you don't want to show the column in the table, just you create, but you don't show as a table column.
    private String city;

}

//whatever we write as annotation it is a sql code behind the scene.
//Why object comes only through the UI? e.g. roles in ticketing app