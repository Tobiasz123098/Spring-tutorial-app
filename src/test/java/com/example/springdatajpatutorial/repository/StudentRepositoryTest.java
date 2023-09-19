package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entity.Guardian;
import com.example.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student
                .builder()
                .emailId("qwea@gmail.com")
                .firstName("Daniel")
                .lastName("Mistrzewski")
//                .guardianName("Narrow")
//                .guardianEmail("Narrow@gmail.com")
//                .guardianMobile("111 111 111")
                .build();

        studentRepository.save(student);
    }
//new Guardian("Amadeusz", "Listowski", "123 123 123")
    @Test
    public void saveStudentWithGuardian() {
        Student student = Student.builder()
                .firstName("Emma")
                .lastName("Lief")
                .emailId("emmaleaf@gmail.com")
                .guardian(Guardian.builder()
                        .name("Amadeusz")
                        .email("amadeusz@gmail.com")
                        .mobile("123 123 123")
                        .build())
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student list: " + studentList);
    }

    @Test
    public void findStudentByName() {

        List<Student> students = studentRepository.findByFirstName("Mateusz");

        System.out.println("students = " + students);
    }

    @Test
    public void findStudentByNameContaining() {

        List<Student> students = studentRepository.findByFirstNameContaining("eusz");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> guardians = studentRepository.findByGuardianName("Amadeusz");

        System.out.println(guardians);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        final var student  = studentRepository.getStudentByEmailAddress("tc@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        final var student  = studentRepository.getStudentFirstNameByEmailAddress("tc@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        final var student  = studentRepository.getStudentByEmailAddressNative("tc@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNative() {
        final var student  = studentRepository.getStudentFirstNameByEmailAddressNative("tc@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNativeNamedParam() {
        final var student  = studentRepository.getStudentFirstNameByEmailAddressNativeNamedParam("tc@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId("Marcin", "tc@gmail.com");
    }

}