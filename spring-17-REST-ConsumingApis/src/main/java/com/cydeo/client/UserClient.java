package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name="USER-CLIENT") //name is simply definer, it makes much more sense when we come to Microservices.
public interface UserClient {

    @GetMapping("/users")
    List<User> getUsers();

}
