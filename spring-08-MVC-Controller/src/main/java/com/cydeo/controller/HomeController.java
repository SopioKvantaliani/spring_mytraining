package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping ("/home")
    public String home () {
        return "home.html"; //We need to define end point, and we need to use @RequestMapping
    }
    @RequestMapping
    public String getHomePage2(){
        return "home.html";
    }
    @RequestMapping("/sopo")
    public String getHomePage3(){
        return "sopo.html";
    }

}
