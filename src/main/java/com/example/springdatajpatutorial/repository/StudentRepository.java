package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

    List<Student> findByFirstName(String name);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String name, String lastName);

    @Query("select e from Student e where e.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select f.firstName from Student f where f.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "SELECT s.first_name FROM tbl_student s WHERE s.email_address = ?1", nativeQuery = true)
    String getStudentFirstNameByEmailAddressNative(String emailId);

    @Query(value = "SELECT s.first_name FROM tbl_student s WHERE s.email_address = :emailAddress", nativeQuery = true)
    String getStudentFirstNameByEmailAddressNativeNamedParam(@Param("emailAddress") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update Student s set s.firstName = ?1 where s.emailId = ?2")
    int updateStudentNameByEmailId(String firstName, String emailId);
}


