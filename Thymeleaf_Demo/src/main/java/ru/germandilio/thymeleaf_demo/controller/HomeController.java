package ru.germandilio.thymeleaf_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView("index");
    }

    @GetMapping("/access-denied")
    public ModelAndView accessDeniedPage() {
        return new ModelAndView("access-denied");
    }
}
