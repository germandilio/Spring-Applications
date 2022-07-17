package ru.germandilio.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView viewHome() {
        ModelAndView helloModel = new ModelAndView();
        helloModel.setViewName("home");

        helloModel.addObject("helloObject", "Hello World!");
        return helloModel;
    }
}
