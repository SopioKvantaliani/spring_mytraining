package com.cydeo.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //or @Qualifier in the constructor
public class OverTimeHours implements HoursRepositoryInterface{
    @Override
    public int getHours() {
        return 15;
    }
}
