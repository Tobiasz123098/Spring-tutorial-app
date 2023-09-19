package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entity.Course;
import com.example.springdatajpatutorial.entity.Student;
import com.example.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        final var courses = courseRepository.findAll();
        System.out.println("courses" + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Stefan")
                .lastName("Brzezinski")
                .build();


        Course course = Course.builder()
                .title("Java")
                .teacher(teacher)
                .credit(14)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        final var courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Student student = Student.builder()
                .firstName("Bartek")
                .lastName("Niedzwiedzki")
                .emailId("niedzwi@gmail.com")
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Fred")
                .lastName("Lipski")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(11)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}