package ru.germandilio.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin")
@Controller
public class HomeAdminController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView viewHome() {
        ModelAndView helloModel = new ModelAndView();
        helloModel.setViewName("admin/home");

        helloModel.addObject("helloObject", "Hello World!");
        return helloModel;
    }
}
