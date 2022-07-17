package ru.germandilio.helloworld.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.germandilio.helloworld.Student;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Value("#{countries}")
    private Map<String, String> countries;

    @Value("#{languages}")
    private Map<String, String> languages;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return prepareStudentForm(new Student());
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute("student") @Valid Student student, BindingResult result) {
        if (result.hasErrors())
            return prepareStudentForm(student);

        var confirmStudentPage = new ModelAndView("student/student-confirm");

        confirmStudentPage.addObject("student", student);
        return confirmStudentPage;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        // create a String trimmer
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    private ModelAndView prepareStudentForm(Student model) {
        var studentForm = new ModelAndView("student/student-form");

        if (model == null)
            model = new Student();

        studentForm.addObject("student", model);
        studentForm.addObject("countries", countries);
        studentForm.addObject("languages", languages);
        return studentForm;
    }
}
