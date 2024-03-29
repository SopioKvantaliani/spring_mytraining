package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users"; //Uniform Resource Identifier

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<User[]> readAllUsers(){

        return restTemplate.getForEntity(URI, User[].class); //getForEntity asks URI we are trying to consume and class. getForEntity accepting array.
        //this is syntax

    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){

        String URL = URI + "/{id}"; //based on id it shows certain ID. that's why we concatenate id with URI
        return restTemplate.getForObject(URL, Object.class,id); //we need to put id, otherwise it will give us error.

    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){

        //Syntax to create HTTP headers. And we can set headers using this Syntax.
        //We are setting headers here.

        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

    }

}
