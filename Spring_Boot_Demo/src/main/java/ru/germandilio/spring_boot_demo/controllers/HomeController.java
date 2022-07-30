package ru.germandilio.spring_boot_demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HomeController {
    @Value("${germandilio.country}")
    private String country;

    @GetMapping("/")
    public String homePage() {
        return "Hello, world! Time on server = " + LocalDateTime.now();
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "Hello page";
    }
}
