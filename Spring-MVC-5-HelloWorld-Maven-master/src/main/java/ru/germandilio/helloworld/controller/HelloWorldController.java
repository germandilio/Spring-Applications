package ru.germandilio.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/showForm")
    public ModelAndView showHelloWord() {
        return new ModelAndView("helloworld-form");
    }

    @RequestMapping(value = "/processName", method = RequestMethod.POST)
    public ModelAndView processName(@RequestParam("studentName") String studentName) {
        var helloSubmitView = new ModelAndView("helloworld");

        helloSubmitView.addObject("studentName", studentName.toUpperCase(Locale.ROOT));
        return helloSubmitView;
    }
}
