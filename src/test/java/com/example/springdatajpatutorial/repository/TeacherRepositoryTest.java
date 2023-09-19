package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entity.Course;
import com.example.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherWithCourse() {
        final var courseMath = Course.builder()
                .title("Math")
                .credit(123)
                .build();

        final var courseChinese = Course.builder()
                .title("Chinese")
                .credit(23)
                .build();


        final var teacher = Teacher.builder()
                .firstName("Tomasz")
                .lastName("Domieszko")
//                .courses(List.of(courseMath, courseChinese))
                .build();

        teacherRepository.save(teacher);
    }
}