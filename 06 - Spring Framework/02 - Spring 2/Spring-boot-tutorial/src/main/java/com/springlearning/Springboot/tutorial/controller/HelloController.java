package com.springlearning.Springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Controller
@RestController //This annotation signifies that this component is a Controller for REST API, and it will always contain a Response body (not some HTML or JSP)
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String helloWorld() {
//        return "Welcome to Daily Code Buffer!!!";
        return welcomeMessage;
    }
}
