package com.example.springboot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, This is CICD Jenkins Project !!";
    }

    @GetMapping("/test")
    public String sayTest() {
        return "Hello, This is a my first  project !!";
    }
}
