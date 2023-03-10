package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //Inside controller class we will look for end points
@RequestMapping("/student") //class level annotation and endpoint will be concatenated with register. So, class level end-point+method level endpoint
public class StudentController { //class level we put requestMapping, we can't use GetMapping or PostMapping


    //   @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")  //localhost:8080/student/register
    //  This two lines are the same

    public String register (Model model) {
    model.addAttribute("students", DataGenerator.createStudent());

        return "student/register"; //view endpoint
    }

    @RequestMapping("/drop") //localhost:8080/student/drop
    public String drop () {

        return "student/register"; //view
    }

 //   @RequestMapping("/welcome")
    @PostMapping("/welcome") //localhost:8080/student/welcome?id=3
    //When we post something we use PostMapping
    public String welcome () {

        return "student/welcome"; //view
    }

}
