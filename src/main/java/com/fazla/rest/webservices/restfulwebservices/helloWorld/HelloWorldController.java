package com.fazla.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Welcome to Hello World";
    }

    @GetMapping("/helloWorld-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Welcome to hello world bean");
    }

}
