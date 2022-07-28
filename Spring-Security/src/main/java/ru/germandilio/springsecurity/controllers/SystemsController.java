package ru.germandilio.springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/systems")
public class SystemsController {
    @GetMapping("/")
    public ModelAndView showLeadersConsole() {
        return new ModelAndView("systems/systems-console");
    }
}
