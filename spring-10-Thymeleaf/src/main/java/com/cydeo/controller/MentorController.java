package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @GetMapping("/register") //localhost:8080/mentor/register
    public String register (Model model) {

        List<String> batchList = Arrays.asList("JD1", "JD2", "JD3");
        model.addAttribute("batchList", batchList   );

        model.addAttribute("mentor", new Mentor());//"mentor" holds empty Object. We need to pass this object in the html 'form'

        return "mentor/mentor-register";
    }

    @PostMapping("/confirm") //localhost:8080/mentor/register/confirm
    public String submitForm (@ModelAttribute("mentor") Mentor mentor) { //new syntax


        //how can I access to "mentor" attribute in this method
        return "mentor/mentor-confirmation";
    }

    //it is possible to have Post and GetMapping at the same time with the same endpoint
    @GetMapping("/confirm") //localhost:8080/mentor/confirm
    public String submitForm2 () {
        return "mentor/mentor-confirmation";
    }



}
