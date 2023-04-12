package com.cydeo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass //annotation means it provides inheritance relationship to other child classes
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Postgres you create id for me
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;


}
