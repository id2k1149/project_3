package org.id2k1149.project_3.controllers;

import org.id2k1149.project_3.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    @GetMapping
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "John",
                        "john@test.test",
                        LocalDate.of(1940, Month.OCTOBER, 9),
                        40)
        ) ;
    }
}
