package ru.germandilio.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/access-denied")
    public ModelAndView accessDeniedPage() {
        return new ModelAndView("errors/access-denied");
    }
}
