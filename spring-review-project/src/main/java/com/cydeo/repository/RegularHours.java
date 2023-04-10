package com.cydeo.repository;

import org.springframework.stereotype.Component;

@Component
public class RegularHours implements HoursRepositoryInterface{
    @Override
    public int getHours() {
        return 15;
    }
}
