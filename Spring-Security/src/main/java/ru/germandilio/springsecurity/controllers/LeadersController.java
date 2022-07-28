package ru.germandilio.springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/leaders")
public class LeadersController {
    @GetMapping("/")
    public ModelAndView showLeadersConsole() {
        return new ModelAndView("leaders/leaders-console");
    }
}
