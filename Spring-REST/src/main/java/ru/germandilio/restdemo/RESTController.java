package ru.germandilio.restdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.germandilio.restdemo.entity.Student;
import ru.germandilio.restdemo.errors.StudentNotFoundException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RESTController {
    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(new Student("John", "Biden"));
        students.add(new Student("Emanuel", "Macron"));
    }

    @GetMapping("/hello-world")
    public String helloWord() {
        return "Hello, world!";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        if (id < 0 || id >= students.size()) {
            throw new StudentNotFoundException("Student with id=" + id + " not found");
        }

        return students.get(id);
    }
}
