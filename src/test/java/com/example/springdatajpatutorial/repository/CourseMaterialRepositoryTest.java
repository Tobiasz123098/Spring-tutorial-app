package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entity.Course;
import com.example.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

//    @Test
//    public void saveCourseMaterialWithCourseTest() {
//        final var course = Course.builder()
//                .credit(123)
//                .title("Testowy title")
//                .build();
//
//         final var courseMaterialEntity = CourseMaterial.builder()
//                .url("http://testowy:8080.pl")
//                .course(course)
//                .build();
//
//        courseMaterialRepository.save(courseMaterialEntity);
//    }

    @Test
    public void printAllCourses() {
        final var allCourses = courseMaterialRepository.findAll();
        System.out.println(allCourses);
    }

}