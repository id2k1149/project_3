package org.id2k1149.project_3.servise;

import org.id2k1149.project_3.models.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
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
