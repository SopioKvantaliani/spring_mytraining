package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Inside controller class we will look for end points
@RequestMapping("/student") //class level annotation and endpoint will be concatenated with register. So, class level end-point+method level endpoint
public class StudentController {

    @RequestMapping("/register") //localhost:8080/student/register
    public String register (Model model) {
    model.addAttribute("students", DataGenerator.createStudent());

        return "student/register"; //view endpoint
    }

    @RequestMapping("/drop") //localhost:8080/student/drop
    public String drop () {

        return "student/register"; //view
    }

    @RequestMapping("/welcome") //localhost:8080/student/welcome?id=3
    public String welcome () {

        return "student/welcome"; //view
    }

}
