package ru.germandilio.springsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/")
    public ModelAndView showLoginPage() {
        return new ModelAndView("login/login-form");
    }

    @PostMapping("/processing")
    public ModelAndView processLoginForm() {
        return null;
    }
}
